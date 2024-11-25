package co.istad.category.feature;

import co.istad.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Boolean existsByCategoryName(String categoryName);
    Optional<Category> findByCategoryId(Integer categoryId);
}
