package com.bicycle.equity.controller;

import com.bicycle.equity.action.OrderAction;
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

    @Autowired
    private OrderAction orderAction;

    @GetMapping("/send")
    public String send() {
        orderAction.createOrder();
        return "Message Sent!";
    }
}
