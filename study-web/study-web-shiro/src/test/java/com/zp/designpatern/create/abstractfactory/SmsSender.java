package com.zp.designpatern.create.abstractfactory;

/**
 * Created by Zhang Peng on 2016/7/25.
 */
public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("This sms sender!");
    }
}
