package com.example.demo.strategydemo.service.impl;

import com.bifrost.config.lock.LockKeyParam;
import com.bifrost.config.lock.LockSupport;
import com.example.demo.strategydemo.Strategy.OrderStrategy;
import com.example.demo.strategydemo.config.HandlerOrderContext;
import com.example.demo.strategydemo.entity.Order;
import com.example.demo.strategydemo.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class orderServiceImpl implements orderService {
    @Autowired
    HandlerOrderContext handlerOrderContext;

    @LockSupport(prefix = "monkeyRun:order")
    @Override
    public void handleOrder(@LockKeyParam String orderID, Order order) {
        //使用策略处理订单
        OrderStrategy orderStrategy = handlerOrderContext.getOrderStrategy(order.getType());
        orderStrategy.handleOrder(order);
    }
}
