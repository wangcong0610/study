package com.zp.excel.test.load;

import com.xiaomi.iauth.java.sdk.common.AppInfo;
import com.xiaomi.iauth.java.sdk.utils.AppLoaderInterface;

/**
 * Author:zp
 * Date:2017/11/27 0027
 * Description:
 */
public class TestAppLoader implements AppLoaderInterface {

    public AppInfo getAppInfo() {
        AppInfo appInfo = new AppInfo();
        appInfo.setAppId(6008065l);
        appInfo.setAppSecret("YuxbJPiMkdHdL8wQt58KRQ==");
        return appInfo;
    }

}
