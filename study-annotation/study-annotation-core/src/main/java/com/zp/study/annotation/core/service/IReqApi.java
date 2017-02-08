package com.zp.study.annotation.core.service;

import com.zp.study.annotation.core.annotation.ReqParam;
import com.zp.study.annotation.core.annotation.ReqType;
import com.zp.study.annotation.core.annotation.ReqUrl;

/**
 * Author: Zhang Peng
 * Date: 2017/1/20 0020
 * Description:
 */
public interface IReqApi {
    @ReqType(reqType = ReqType.ReqTypeEnum.POST)//声明采用post请求
    @ReqUrl(reqUrl = "www.xxx.com/openApi/login")// 请求Url地址
    String login(@ReqParam("userId") String userId, @ReqParam("pwd") String pwd);//参数用户名 密码
}
