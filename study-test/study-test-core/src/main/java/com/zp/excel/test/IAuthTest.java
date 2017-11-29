package com.zp.excel.test;

import com.xiaomi.iauth.java.sdk.app.IAuthAppSDKTool;
import com.xiaomi.iauth.java.sdk.common.IAuthTokenInfo;
import com.xiaomi.iauth.java.sdk.constants.IAuthConstants;
import com.xiaomi.iauth.java.sdk.exception.IAuthException;
import com.xiaomi.iauth.java.sdk.exception.IAuthSDKException;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

/**
 * Author:zp
 * Date:2017/11/27 0027
 * Description:
 */
public class IAuthTest {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String CHAR_SET = "UTF-8";

    private static final Logger logger = Logger.getLogger(IAuthTest.class);

    public static void main(String[] args) throws IAuthException, URISyntaxException, IAuthSDKException {
        IAuthTokenInfo info = null;
        // 第一个参数是请求的ServiceID，第二参数代表每次获取token时，是从缓存中取（false），推荐用false;
        info = IAuthAppSDKTool.getInstance(null).getIAuthToken("micloud", false);

        System.out.println();
        System.out.println(info.getToken());

        new IAuthTest().query(info);

    }

    private void query(IAuthTokenInfo info) {
        CloseableHttpClient httpClient = null;
        BufferedReader reader = null;
        try {

            URIBuilder uriBuilder = new URIBuilder("http://internalapi.preview.micloud.srv");
            uriBuilder.setPath("/mic/vip/user/870468480/vip/level");
            uriBuilder.setParameter(IAuthConstants.APP_ID, info.getAppId() + "");
            uriBuilder.setParameter(IAuthConstants.TOKEN, info.getToken());
            // uriBuilder.setParameter(IAuthConstants.domain, info.getDomain());
            httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            httpGet.addHeader("User-Agent", USER_AGENT);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).setConnectionRequestTimeout(5000).build();
            httpGet.setConfig(requestConfig);
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                logger.info("statusCode = " + statusCode + ", statusLine： " + httpResponse.getStatusLine());// 打印结果页面
            }

            reader = new BufferedReader(new InputStreamReader(
                    httpResponse.getEntity().getContent(), CHAR_SET));

            String inputLine = null;
            StringBuffer responseBuffer = new StringBuffer();

            while ((inputLine = reader.readLine()) != null) {
                responseBuffer.append(inputLine);
            }

            logger.info("查询完成：" + responseBuffer.toString());
        } catch (IOException e) {
            logger.error("查询失败", e);
            return;
        } catch (URISyntaxException e) {
            logger.error("创建url失败", e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
