package com.zp.designpatern.create.abstractfactory;

/**
 * Created by Zhang Peng on 2016/7/25.
 */
public class SendSmsFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
