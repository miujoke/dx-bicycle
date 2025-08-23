package com.bicycle.mq.producer;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Service;

/**
 * @author miujoke
 * @date 2025/8/23 17:41
 */
@Service
public class MqProducerService {

    private final RocketMQTemplate rocketMQTemplate;

    public MqProducerService(RocketMQTemplate rocketMQTemplate) {
        this.rocketMQTemplate = rocketMQTemplate;
    }

    public void sendMessage(String topic, String message) {
        rocketMQTemplate.convertAndSend(topic, message);
        System.out.println("消息已发送到主题: " + topic + " 内容: " + message);
    }
}
