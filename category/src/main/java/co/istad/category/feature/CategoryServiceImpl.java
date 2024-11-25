package co.istad.category.feature;

import co.istad.category.custom.CustomMetric;
import co.istad.category.domain.Category;
import co.istad.category.dto.CategoryCreateRequest;
import co.istad.category.dto.CategoryResponse;
import co.istad.category.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final CustomMetric customMetric;


    //  create category
    @Override
    public CategoryResponse createCategory(CategoryCreateRequest categoryCreateRequest) {
        // Validate category
        if (categoryRepository.existsByCategoryName(categoryCreateRequest.categoryName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "This category already exists!");
        }
    // transform DTO to domain model
    Category category = categoryMapper.fromCategoryCreateRequest(categoryCreateRequest);
    // save to database
    categoryRepository.save(category);
    // Increment the counter for created products
    customMetric.getCategoryCreatedCounter().increment();

        return categoryMapper.toCategoryResponse(category);
    }

    // get category by ID
    @Override
    public CategoryResponse getCategory(Integer categoryId) {
    // validate category
    Category category = categoryRepository.findByCategoryId(categoryId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Category!"));
        // Increment the counter for fetched category
        return categoryMapper.toCategoryResponse(category);
    }

    // get all categories
    @Override
    public List<CategoryResponse> getCategories() {
    List<Category> categories = categoryRepository.findAll();
        // Increment the counter for fetching all categories

        return categoryMapper.toCategoryResponseList(categories);
    }

    // delete category
    @Override
    public void deleteCategory(Integer categoryId) {
    Category category = categoryRepository.findByCategoryId(categoryId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Category!"));
    categoryRepository.delete(category);
    }
}
