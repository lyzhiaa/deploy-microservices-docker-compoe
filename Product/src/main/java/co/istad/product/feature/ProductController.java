package co.istad.product.feature;

import co.istad.product.dto.ProductCreateRequest;
import co.istad.product.dto.ProductResponse;
import co.istad.product.dto.ProductUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/products")
//public class ProductController {
//    private final ProductService productService;
//
//    // create product
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping
//    void createProduct(@Valid @RequestBody ProductCreateRequest productCreateRequest){
//        productService.createProduct(productCreateRequest);
//    }
//    // update product
//    @PatchMapping("/{id}")
//    void UpdateProduct(@Valid @PathVariable Integer id, @RequestBody ProductUpdateRequest productUpdateRequest) {
//        productService.updateProduct(id, productUpdateRequest);
//    }
//    // get unique product
//    @GetMapping("/{id}")
//    ProductResponse getUniqueProduct(@Valid @PathVariable Integer id) {
//        return productService.getProductById(id);
//    }
//    // get all product
//    @GetMapping
//    List<ProductResponse> getAllProduct() {
//        return productService.getAllProduct();
//    }
//
//}
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    // Create product
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createProduct(@Valid @RequestBody ProductCreateRequest productCreateRequest) {
        productService.createProduct(productCreateRequest);
    }

    // Update product
    @PatchMapping("/{id}")
    void updateProduct(@Valid @PathVariable Integer id, @RequestBody ProductUpdateRequest productUpdateRequest) {
        productService.updateProduct(id, productUpdateRequest);
    }

    // Get unique product
    @GetMapping("/{id}")
    ProductResponse getUniqueProduct(@Valid @PathVariable Integer id) {
        return productService.getProductById(id);
    }

    // Get all products
    @GetMapping
    List<ProductResponse> getAllProduct() {
        return productService.getAllProduct();
    }
}
