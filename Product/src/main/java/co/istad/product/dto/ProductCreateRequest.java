package co.istad.product.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductCreateRequest (
    @NotBlank(message = "Name of product is required!!!")
    String productName,
    @NotBlank(message = "Description of product is required!!!")
    String description,
    @NotNull(message = "Price of product is required!!!")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
    BigDecimal price
) {
}
