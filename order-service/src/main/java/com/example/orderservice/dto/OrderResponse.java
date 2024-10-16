package com.example.orderservice.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record OrderResponse(
        Integer id,
        Integer productId,
        Integer quantity,
        BigDecimal price
) {
}
