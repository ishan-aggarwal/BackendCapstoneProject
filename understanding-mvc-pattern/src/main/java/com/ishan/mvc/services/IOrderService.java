package com.ishan.mvc.services;

import com.ishan.mvc.models.Order;

import java.util.List;

public interface IOrderService {
    Order getOrderById(Long orderId);

    List<Order> getAllOrders();
}
