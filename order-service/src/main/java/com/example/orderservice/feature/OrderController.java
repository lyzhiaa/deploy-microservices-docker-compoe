package com.example.orderservice.feature;

import com.example.orderservice.dto.OrderCreateRequest;
import com.example.orderservice.dto.OrderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    // create order
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createOrder(@Valid @RequestBody OrderCreateRequest orderCreateRequest) {
        orderService.createOrder(orderCreateRequest);
    }

    // get unique
    @GetMapping("/{id}")
    OrderResponse getOrder(@Valid @PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    //Get all order
    @GetMapping
    List<OrderResponse> getAllOrder() {
        return orderService.getAllOrder();
    }
}
