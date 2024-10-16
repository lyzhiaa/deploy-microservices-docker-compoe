package co.istad.product.custom;

import co.istad.product.feature.ProductRepository;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CustomMetric {
    private final Counter productCreatedCounter;
    private final Counter productUpdatedCounter;
    private final Counter productFetchedCounter;
    private final Counter productsFetchedCounter;
    private final Gauge totalProductsGauge;

    // Constructor to initialize all counters and gauge
    public CustomMetric(MeterRegistry meterRegistry, ProductRepository productRepository) {
        this.productCreatedCounter = meterRegistry.counter("products_created_total");
        this.productUpdatedCounter = meterRegistry.counter("products_updated_total");
        this.productFetchedCounter = meterRegistry.counter("get_unique_product_total");
        this.productsFetchedCounter = meterRegistry.counter("get_all_products_total");

        // Gauge for tracking the total number of products
        this.totalProductsGauge = Gauge.builder("products_total", productRepository::count)
                .description("Total number of products")
                .register(meterRegistry);
    }
}