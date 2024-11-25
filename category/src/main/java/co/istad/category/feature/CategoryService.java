package co.istad.category.feature;


import co.istad.category.dto.CategoryCreateRequest;
import co.istad.category.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {
    // create category
    CategoryResponse createCategory(CategoryCreateRequest categoryCreateRequest);
    // get category
    CategoryResponse getCategory(Integer categoryId);
    // get all categories
    List<CategoryResponse> getCategories();
    // delete category
    void deleteCategory(Integer categoryId);
}
