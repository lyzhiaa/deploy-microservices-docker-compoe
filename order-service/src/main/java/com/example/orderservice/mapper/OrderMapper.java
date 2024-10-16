package com.example.orderservice.mapper;

import com.example.orderservice.dto.OrderCreateRequest;
import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface OrderMapper {
    // Get specific Order
    OrderResponse toOrderResponse(Order order);
    //create order
    Order fromOrderCreateRequest(OrderCreateRequest orderCreateRequest);
    // get all orders
    List<OrderResponse> toOrderResponseList(List<Order> orders);
}
