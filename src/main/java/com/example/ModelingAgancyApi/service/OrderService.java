package com.example.ModelingAgancyApi.service;

import com.example.ModelingAgancyApi.dto.OrderCreateRequest;
import com.example.ModelingAgancyApi.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    // ✅ NEW clean method
    Order saveOrder(OrderCreateRequest request);

    List<Order> getAllOrders();

    Optional<Order> getOrderById(Long id);

    Order updateOrder(Long id, Order orderDetails);

    void deleteOrder(Long id);
}
