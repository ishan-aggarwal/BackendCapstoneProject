package com.ishan.mvc.services;

import com.ishan.mvc.models.Order;
import com.ishan.mvc.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository OrderRepository;

    @Override
    public Order getOrderById(Long orderId) {
        return OrderRepository.findById(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return OrderRepository.findAll();
    }
}
