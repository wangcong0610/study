package com.zp.designpatern.structure.proxy;

/**
 * Created by Zhang Peng on 2016/8/1.
 */
public class ProxyTest {
    public static void main(String[] args) {
        Sourceable sourceable = new Proxy();
        sourceable.method();
    }
}
