package com.pengzhangg.study.mq.rocketmq.core.producer;


import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

/**
 * Author:Zhang Peng
 * Date:2017/4/7 0007
 * Description:TODO
 */
public class Producer {
    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("Producer");
        producer.setNamesrvAddr("192.168.146.109:9876");
        try {
            producer.start();

            Message msg = new Message("PushTopic",
                    "push",
                    "1",
                    "Just for test.".getBytes());

            SendResult result = producer.send(msg);
            System.out.println("id:" + result.getMsgId() +
                    " result:" + result.getSendStatus());

            msg = new Message("PushTopic",
                    "push",
                    "2",
                    "Just for test.".getBytes());

            result = producer.send(msg);
            System.out.println("id:" + result.getMsgId() +
                    " result:" + result.getSendStatus());

            msg = new Message("PullTopic",
                    "pull",
                    "1",
                    "Just for test.".getBytes());

            result = producer.send(msg);
            System.out.println("id:" + result.getMsgId() +
                    " result:" + result.getSendStatus());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.shutdown();
        }
    }
}
