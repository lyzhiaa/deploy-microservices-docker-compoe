package com.example.orderservice.feature;

import com.example.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findById(Integer id);
    Optional<Order> findByProductId(Integer productId);
}
