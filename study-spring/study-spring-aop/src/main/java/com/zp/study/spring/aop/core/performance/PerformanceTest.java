package com.zp.study.spring.aop.core.performance;

import com.zp.study.spring.aop.core.cglib.CglibAopDemo;
import com.zp.study.spring.aop.core.dynamicproxy.DynamicProxyDemo;
import com.zp.study.spring.aop.core.dynamicproxy.ProxyBusiness;

public class PerformanceTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        DynamicProxyDemo.aop();
        long end = System.currentTimeMillis();
        long dynamicProxyNeedTime = end - start;

        start = System.currentTimeMillis();
        ProxyBusiness.staticDynamic();
        end = System.currentTimeMillis();
        long staticProxyNeedTime = end - start;

        start = System.currentTimeMillis();
        CglibAopDemo.byteCodeGe();
        end = System.currentTimeMillis();
        long byteCodeGeNeedTime = end - start;

        System.out.println("dynamicProxy need time:" + dynamicProxyNeedTime + "ms");
        System.out.println("staticDynamic need time:" + staticProxyNeedTime + "ms");
        System.out.println("byteCodeGe need time:" + byteCodeGeNeedTime + "ms");
    }

}
