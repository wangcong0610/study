package com.zp.designpatern.behavior.observer;

/**
 * Created by Zhang Peng on 2016/8/1.
 */
public class Observer1 implements Observer {
    @Override
    public void update() {
        System.out.println("observer1 has received!");
    }
}
