package com.ishan.mvc.repositories;

import com.ishan.mvc.models.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepository {
    private final Map<Long, Order> orders;

    public OrderRepository() {
        orders = new HashMap<>();
    }

    public Order findById(Long orderId) {
        return orders.get(orderId);
    }

    public Order save(Order order) {
        orders.put(order.getId(), order);
        return orders.get(order.getId());
    }

    public List<Order> findAll() {
        return new ArrayList<>(orders.values());
    }
}
