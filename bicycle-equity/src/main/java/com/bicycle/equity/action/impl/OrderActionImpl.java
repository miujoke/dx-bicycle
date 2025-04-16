package com.bicycle.equity.action.impl;

import com.bicycle.equity.action.OrderAction;
import com.bicycle.service.producer.MqProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author miujoke
 * @date 2025/4/16 22:15
 */
@Service
public class OrderActionImpl implements OrderAction {

    @Autowired
    private MqProducerService mqProducerService;

    public void createOrder() {
        // 业务处理...
        mqProducerService.send("order-topic", "新订单已创建");
    }
}
