package com.ishan.mvc.controllers;

import com.ishan.mvc.models.Order;
import com.ishan.mvc.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping("/orders/{oid}")
    public Order getOrderById(@PathVariable("oid") Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }
}
