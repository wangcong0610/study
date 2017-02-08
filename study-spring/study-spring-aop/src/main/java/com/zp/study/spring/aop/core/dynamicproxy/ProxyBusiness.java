package com.zp.study.spring.aop.core.dynamicproxy;

import com.zp.study.spring.aop.core.model.impl.Business;
import com.zp.study.spring.aop.core.model.IBusiness;
import com.zp.study.spring.aop.core.model.IBusiness2;

import java.lang.reflect.Method;


/**
 * 织入器生成的代理类
 */
public class ProxyBusiness implements IBusiness, IBusiness2 {

    private DynamicProxyDemo.LogInvocationHandler h;

    @Override
    public void doSomeThing2() {
        try {
            Method m = (h.target).getClass().getMethod("doSomeThing", null);
            h.invoke(this, m, null);
        } catch (Throwable e) {
            // 异常处理 1（略）
        }
    }

    @Override
    public boolean doSomeThing() {
        try {
            Method m = (h.target).getClass().getMethod("doSomeThing2", null);
            return (Boolean) h.invoke(this, m, null);
        } catch (Throwable e) {
            // 异常处理 1（略）
        }
        return false;
    }

    public ProxyBusiness(DynamicProxyDemo.LogInvocationHandler h) {
        this.h = h;
    }

    //测试用
    public static void main(String[] args) {
        //构建AOP的Advice
        staticDynamic();
    }

    public static void staticDynamic() {
        DynamicProxyDemo.LogInvocationHandler handler = new DynamicProxyDemo.LogInvocationHandler(new Business());
        new ProxyBusiness(handler).doSomeThing();
        new ProxyBusiness(handler).doSomeThing2();
    }

}
