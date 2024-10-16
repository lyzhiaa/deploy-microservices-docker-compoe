package co.istad.product.feature;

import co.istad.product.dto.ProductCreateRequest;
import co.istad.product.dto.ProductResponse;
import co.istad.product.dto.ProductUpdateRequest;

import java.util.List;

public interface ProductService {
    void createProduct(ProductCreateRequest productCreateRequest);
    void updateProduct(Integer id, ProductUpdateRequest productUpdateRequest);
    ProductResponse getProductById(Integer id);
    List<ProductResponse> getAllProduct();
}
