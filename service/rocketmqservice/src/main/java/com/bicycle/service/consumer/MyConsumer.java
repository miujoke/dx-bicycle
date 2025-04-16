package com.bicycle.service.consumer;

import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author miujoke
 * @date 2025/4/16 21:56
 */
@Service
@RocketMQMessageListener(
        topic = "my-topic",
        consumerGroup = "my-consumer-group",
        messageModel = MessageModel.CLUSTERING // 广播模式用：BROADCASTING
)
public class MyConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        System.out.println("Received: " + message);
    }
}
