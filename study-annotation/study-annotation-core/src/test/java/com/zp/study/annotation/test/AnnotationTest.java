package com.zp.study.annotation.test;

import com.zp.study.annotation.core.annotation.ReqParam;
import com.zp.study.annotation.core.annotation.ReqType;
import com.zp.study.annotation.core.annotation.ReqUrl;
import com.zp.study.annotation.core.service.IReqApi;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author: Zhang Peng
 * Date: 2017/1/20 0020
 * Description:
 */
public class AnnotationTest {

    private static final String TAG = "";

    public static void main(String[] args) {
        new AnnotationTest().testApi();
    }

    public void testApi() {
        IReqApi api = create(IReqApi.class);
        api.login("zp", "123456");
    }

    public <T> T create(final Class<T> service) {
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[]{service},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object... args)
                            throws Throwable {// Annotation[]  methodAnnotations = method.getAnnotations();//拿到函数注解数组
                        ReqType reqType = method.getAnnotation(ReqType.class);
//                        Log.e(TAG, "IReqApi---reqType->" + (reqType.reqType() == ReqType.ReqTypeEnum.POST ? "POST" : "OTHER"));
                        System.out.println("IReqApi---reqType->" + (reqType.reqType() == ReqType.ReqTypeEnum.POST ? "POST" : "OTHER"));
                        ReqUrl reqUrl = method.getAnnotation(ReqUrl.class);
//                        Log.e(TAG, "IReqApi---reqUrl->" + reqUrl.reqUrl());
                        System.out.println("IReqApi---reqUrl->" + reqUrl.reqUrl());
//                        Type[] parameterTypes = method.getGenericParameterTypes();
                        Annotation[][] parameterAnnotationsArray = method.getParameterAnnotations();//拿到参数注解
                        for (int i = 0; i < parameterAnnotationsArray.length; i++) {
                            Annotation[] annotations = parameterAnnotationsArray[i];
                            if (annotations != null) {
//                                System.out.println(annotations.length);// 1
                                ReqParam reqParam = (ReqParam) annotations[0];
//                                Log.e(TAG, "reqParam---reqParam->" + reqParam.value() + "==" + args[i]);
                                System.out.println("reqParam---reqParam->" + reqParam.value() + "==" + args[i]);
                            }
                        }
                        //下面就可以执行相应的网络请求获取结果 返回结果
                        String result = "";//这里模拟一个结果
                        return result;
                    }
                });
    }

}
