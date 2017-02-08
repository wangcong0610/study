package com.zp.designpatern.behavior.observer;

/**
 * Created by Zhang Peng on 2016/8/1.
 */
public class MySubject extends AbstractSubject {
    @Override
    public void operation() {
        System.out.println("update self!");
        notifyobservers();
    }
}
