package com.zp.designpatern.structure.proxy;

/**
 * Created by Zhang Peng on 2016/8/1.
 */
public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("the original method!");
    }
}
