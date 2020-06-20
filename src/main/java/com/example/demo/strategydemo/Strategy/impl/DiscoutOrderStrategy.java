package com.example.demo.strategydemo.Strategy.impl;

import com.example.demo.strategydemo.Strategy.OrderStrategy;
import com.example.demo.strategydemo.annotation.HandlerOrderType;
import com.example.demo.strategydemo.entity.Order;
import org.springframework.stereotype.Component;

@Component
@HandlerOrderType(Order.DISCOUT)
public class DiscoutOrderStrategy implements OrderStrategy {
    @Override
    public void handleOrder(Order order) {
        System.out.println("----处理打折订单----");
    }
}