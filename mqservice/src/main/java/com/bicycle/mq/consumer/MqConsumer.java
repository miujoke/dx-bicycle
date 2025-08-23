package com.bicycle.mq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author miujoke
 * @date 2025/8/23 17:44
 */
@Component
@RocketMQMessageListener(topic = "equity-topic", consumerGroup = "equity-consumer-group")
public class MqConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.out.println("收到消息: " + message);
    }
}
