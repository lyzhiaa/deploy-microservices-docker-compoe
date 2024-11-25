package co.istad.category.feature;

import co.istad.category.dto.CategoryCreateRequest;
import co.istad.category.dto.CategoryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    // create category
    @ResponseStatus(HttpStatus .CREATED)
    @PostMapping
    CategoryResponse createCategory(@Valid @RequestBody CategoryCreateRequest categoryCreateRequest) {
        return categoryService.createCategory(categoryCreateRequest);
    }

    // get category by ID
    @GetMapping("/{categoryId}")
    CategoryResponse getCategory(@PathVariable("categoryId") Integer categoryId) {
        return categoryService.getCategory(categoryId);
    }

    // get all categories
    @GetMapping
    List<CategoryResponse> getCategories() {
        return categoryService.getCategories();
    }
}
