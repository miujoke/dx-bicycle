package com.bicycle.mq.config;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author miujoke
 * @date 2025/8/23 18:08
 */
@Configuration
public class RocketMQConfig {
    @Value("${rocketmq.name-server}")
    private String nameServer;

    @Value("${rocketmq.producer.group}")
    private String producerGroup;

    @Bean
    public RocketMQTemplate rocketMQTemplate() {
        DefaultMQProducer producer = new DefaultMQProducer(producerGroup);
        producer.setNamesrvAddr(nameServer);
        // 可根据需要设置其他属性
        RocketMQTemplate template = new RocketMQTemplate();
        template.setProducer(producer);
        return template;
    }
}
