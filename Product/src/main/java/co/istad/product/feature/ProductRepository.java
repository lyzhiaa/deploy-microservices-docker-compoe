package co.istad.product.feature;

import co.istad.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Boolean existsByProductName(String productName);
    Optional<Product> findById(Integer id);
}
