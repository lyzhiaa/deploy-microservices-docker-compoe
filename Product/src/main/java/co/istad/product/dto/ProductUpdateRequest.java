package co.istad.product.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ProductUpdateRequest(
        @NotBlank(message = "Description of product is required!!!")
        String description,
        @NotBlank(message = "Price of product is required!!!")
        BigDecimal price
) {
}
