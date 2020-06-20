package com.example.demo.strategydemo.Strategy;

import com.example.demo.strategydemo.entity.Order;

/**
 * 处理订单策略
 */
public interface OrderStrategy {

    void handleOrder(Order order);
}