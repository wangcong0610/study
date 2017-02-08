package com.zp.designpatern.create.factory.test;

import com.zp.designpatern.create.factory.Sender;
import com.zp.designpatern.create.factory.SenderFactory;

/**
 * Created by Zhang Peng on 2016/7/25.
 */
public class FactoryTester {
    public static void main(String [] arg0){
        try {
            SenderFactory senderFactory = new SenderFactory();
            Sender sender = senderFactory.produce("a");
            sender.send();
        } catch (Exception e) {
            System.out.println("创建Sender失败！");
        }
    }
}
