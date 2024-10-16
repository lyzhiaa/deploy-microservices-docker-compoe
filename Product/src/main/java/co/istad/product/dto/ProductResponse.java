package co.istad.product.dto;

import java.math.BigDecimal;

public record ProductResponse (
        Integer id,
        String productName,
        String description,
        BigDecimal price
) {
}
