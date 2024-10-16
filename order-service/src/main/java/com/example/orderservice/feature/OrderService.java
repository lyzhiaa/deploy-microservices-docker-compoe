package com.example.orderservice.feature;

import com.example.orderservice.dto.OrderCreateRequest;
import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.model.Order;

import java.util.List;

public interface OrderService {
    void createOrder(OrderCreateRequest orderCreateRequest);
    OrderResponse getOrderById(Integer id);
    List<OrderResponse> getAllOrder();
}
