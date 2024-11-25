package co.istad.category.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryCreateRequest (
    @NotBlank(message = "Category name is required")
    String categoryName
) {
}
