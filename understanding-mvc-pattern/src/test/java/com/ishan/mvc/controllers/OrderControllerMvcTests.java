package com.ishan.mvc.controllers;

import com.ishan.mvc.controllers.OrderController;
import com.ishan.mvc.models.Order;
import com.ishan.mvc.models.OrderStatus;
import com.ishan.mvc.services.IOrderService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(OrderController.class)
public class OrderControllerMvcTests {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IOrderService orderService;

    @Test
    public void testGetOrderByIdWithExistingOrder() throws Exception {
        // Arrange
        Order order = new Order();
        order.setId(25L);
        order.setStatus(OrderStatus.INTRANSIT);
        order.setCustomerId(5000L);

        when(orderService.getOrderById(25L)).thenReturn(order);

        // Act & Assert
        mockMvc.perform(get("/orders/25"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(25))
                .andExpect(jsonPath("$.status").value("INTRANSIT"))
                .andExpect(jsonPath("$.customerId").value(5000L));
    }

    @Test
    public void testGetOrders() throws Exception {
        // Arrange
        Order order = new Order();
        order.setId(2L);
        order.setStatus(OrderStatus.COMPLETED);
        order.setCustomerId(1010L);
        List<Order> orders = new ArrayList<>();
        orders.add(order);

        when(orderService.getAllOrders()).thenReturn(orders);

        // Act & Assert
        mockMvc.perform(get("/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(2))
                .andExpect(jsonPath("$[0].status").value("COMPLETED"))
                .andExpect(jsonPath("$[0].customerId").value(1010L));
    }
}
