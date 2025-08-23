package com.bicycle.equity.action.impl;

import com.bicycle.equity.action.OrderAction;
import org.springframework.stereotype.Service;


/**
 * @author miujoke
 * @date 2025/4/16 22:15
 */
@Service
public class OrderActionImpl implements OrderAction {


    public void createOrder() {
        // 业务处理...
//        mqProducerService.send("order-topic", "新订单已创建");
    }
}
