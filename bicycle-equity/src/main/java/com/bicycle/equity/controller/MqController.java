package com.bicycle.equity.controller;

import com.bicycle.equity.action.OrderAction;
import com.bicycle.mq.producer.MqProducerService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author miujoke
 * @date 2025/4/16 21:53
 */
@RestController
@RequestMapping("/mq")
public class MqController {

    Logger logger = LoggerFactory.getLogger(MqController.class);

    @Autowired
    private OrderAction orderAction;

    @GetMapping("/send")
    public String send() {
        orderAction.createOrder();
        return "Message Sent!";
    }

    @Autowired
    private MqProducerService mqProducerService;

    @GetMapping("/t1")
    public String testSend() {
        logger.info("处理接口 /mq/t1 开始");
        mqProducerService.sendMessage("equity-topic", "Hello MQ");
        logger.info("处理接口 /mq/t1 结束");
        return "Message Sent!";
    }
}
