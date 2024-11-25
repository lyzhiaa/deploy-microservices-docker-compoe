package co.istad.category.mapper;

import co.istad.category.domain.Category;
import co.istad.category.dto.CategoryCreateRequest;
import co.istad.category.dto.CategoryResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface CategoryMapper {
    // create category
    Category fromCategoryCreateRequest(CategoryCreateRequest categoryCreateRequest);
    // get category
    CategoryResponse toCategoryResponse(Category category);
    // get all categories
    List<CategoryResponse> toCategoryResponseList(List<Category> categories);
}
