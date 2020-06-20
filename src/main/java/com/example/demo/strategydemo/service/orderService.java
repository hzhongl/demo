package com.example.demo.strategydemo.service;

import com.example.demo.strategydemo.entity.Order;

public interface orderService {


    void handleOrder(String orderId,Order order);
}
