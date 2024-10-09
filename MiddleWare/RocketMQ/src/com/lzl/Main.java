package com.lzl;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

public class Main {
    public static void main(String[] args) throws MQBrokerException, RemotingException, InterruptedException, MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer("TestGroup");
        producer.setNamesrvAddr("10.78.79.223:9876");
        Message message = new Message();
        message.setTopic("TestTopic");
        message.setBody("test消息".getBytes());
        producer.start();
        producer.send(message);
    }
}


