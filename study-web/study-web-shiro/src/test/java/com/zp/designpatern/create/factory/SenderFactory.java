package com.zp.designpatern.create.factory;

/**
 * Created by Zhang Peng on 2016/7/25.
 */
public class SenderFactory {
    public Sender produce(String type){
        if("mail".equals(type)){
            return new MailSender();
        }else if("sms".equals(type)){
            return new SmsSender();
        }else{
            System.out.println("请输入正确的sender类型！");
            return null;
        }
    }
}
