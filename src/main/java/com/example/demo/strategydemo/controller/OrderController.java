package com.example.demo.strategydemo.controller;

import com.example.demo.strategydemo.entity.Order;
import com.example.demo.strategydemo.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
   private orderService orderService;
    @GetMapping("/handler/{type}")
    public void handleOrder(@PathVariable Integer type){

        Order order = new Order().setName("订单").setPrice(999.99).setType(type).setId("12");
        orderService.handleOrder(order.getId(), order);
    }
}