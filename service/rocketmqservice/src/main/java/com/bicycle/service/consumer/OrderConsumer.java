package com.bicycle.service.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author miujoke
 * @date 2025/4/16 22:20
 */
@RocketMQMessageListener(
        topic = "order-topic",
        consumerGroup = "my-producer-group"
)
@Service
public class OrderConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.out.println("收到消息：" + message);
    }
}
