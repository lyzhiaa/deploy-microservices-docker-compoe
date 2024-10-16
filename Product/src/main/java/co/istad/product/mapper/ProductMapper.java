package co.istad.product.mapper;

import co.istad.product.dto.ProductCreateRequest;
import co.istad.product.dto.ProductResponse;
import co.istad.product.dto.ProductUpdateRequest;
import co.istad.product.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface ProductMapper {
    // Get specific product
    ProductResponse toProductResponse(Product product);
    // Update product
    void fromProductUpdateRequest(ProductUpdateRequest productUpdateRequest, @MappingTarget Product product);
    //create product
    Product fromProductCreateRequest(ProductCreateRequest productCreateRequest);
    // get all products
    List<ProductResponse> toProductResponseList(List<Product> products);
}
