package com.bicycle.service.producer;


import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author miujoke
 * @date 2025/4/16 22:08
 */
@Service
public class MqProducerService {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public void send(String topic, Object payload) {
        rocketMQTemplate.convertAndSend(topic, payload);
    }
}
