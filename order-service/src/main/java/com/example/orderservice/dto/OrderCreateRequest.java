package com.example.orderservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record OrderCreateRequest (
        @NotNull(message = "Product Id can not be null !!!")
        Integer productId,
        @NotNull(message = "Quantity can not be null !!!" )
        Integer quantity
) {
}
