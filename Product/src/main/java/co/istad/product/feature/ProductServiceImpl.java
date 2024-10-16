package co.istad.product.feature;

import co.istad.product.custom.CustomMetric;
import co.istad.product.dto.ProductCreateRequest;
import co.istad.product.dto.ProductResponse;
import co.istad.product.dto.ProductUpdateRequest;
import co.istad.product.mapper.ProductMapper;
import co.istad.product.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CustomMetric customMetric;

    // Constructor for injecting dependencies
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, CustomMetric customMetric) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.customMetric = customMetric;
    }

    // Create product
    @Override
    public void createProduct(ProductCreateRequest productCreateRequest) {
        // Validate product
        if (productRepository.existsByProductName(productCreateRequest.productName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "This product already exists!");
        }

        // Transform DTO to domain model
        Product product = productMapper.fromProductCreateRequest(productCreateRequest);

        // Save to database
        productRepository.save(product);

        // Increment the counter for created products
        customMetric.getProductCreatedCounter().increment();
    }

    // Update product
    @Override
    public void updateProduct(Integer id, ProductUpdateRequest productUpdateRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Product!"));
        productMapper.fromProductUpdateRequest(productUpdateRequest, product);

        productRepository.save(product);

        // Increment the counter for updated products
        customMetric.getProductUpdatedCounter().increment();
    }

    // Get product by ID
    @Override
    public ProductResponse getProductById(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Product!"));

        // Increment the counter for fetched products
        customMetric.getProductFetchedCounter().increment();

        return productMapper.toProductResponse(product);
    }

    // Get all products
    @Override
    public List<ProductResponse> getAllProduct() {
        Sort sortById = Sort.by(Sort.Direction.DESC, "id");
        List<Product> products = productRepository.findAll(sortById);

        // Increment the counter for fetching all products
        customMetric.getProductsFetchedCounter().increment();

        return productMapper.toProductResponseList(products);
    }
}