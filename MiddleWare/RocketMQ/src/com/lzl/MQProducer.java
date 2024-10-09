package com.lzl;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

public class MQProducer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("TestProducerGroup");
        producer.setNamesrvAddr("10.83.129.164:9876");
        producer.setRetryAnotherBrokerWhenNotStoreOK(true);
        producer.setRetryTimesWhenSendFailed(5);
        producer.setRetryTimesWhenSendAsyncFailed(5);
        producer.start();

        for (int i = 0; i < 1; i++) {
            Message message = new Message();
            message.setTopic("TestTopic");
            message.setBody(Integer.valueOf(i).toString().getBytes());
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println("------------" + sendResult);
                }

                @Override
                public void onException(Throwable throwable) {
                    System.out.println("------------" + throwable.getMessage());
                }
            });
        }
    }
}
