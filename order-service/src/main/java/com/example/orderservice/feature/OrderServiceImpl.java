package com.example.orderservice.feature;

import com.example.orderservice.dto.OrderCreateRequest;
import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.mapper.OrderMapper;
import com.example.orderservice.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public void createOrder(OrderCreateRequest orderCreateRequest) {
        Order order = orderMapper.fromOrderCreateRequest(orderCreateRequest);
        orderRepository.save(order);
    }

    @Override
    public OrderResponse getOrderById(Integer id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Invalid Order !!!"));
        return orderMapper.toOrderResponse(order);
    }

    @Override
    public List<OrderResponse> getAllOrder() {
        List<Order> orders =orderRepository.findAll();
        return orderMapper.toOrderResponseList(orders);
    }
}
