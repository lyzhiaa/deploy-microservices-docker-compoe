package co.istad.category.custom;


import co.istad.category.feature.CategoryRepository;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CustomMetric {
    private final Counter categoryCreatedCounter;
    private final Counter getCategoryCounter;
    private final Counter getAllCategoriesCounter;
    private final Gauge totalCategoriesGauge;

    public CustomMetric(MeterRegistry meterRegistry, CategoryRepository categoryRepository) {
        // Counter for tracking the total number of categories created
        this.categoryCreatedCounter = meterRegistry.counter("categories_created_total");
        // Counter for tracking the total number of get category requests
        this.getCategoryCounter = meterRegistry.counter("get_category_total");
        // Counter for tracking the total number of get all categories requests
        this.getAllCategoriesCounter = meterRegistry.counter("get_all_categories_total");
        // Gauge for tracking the total number of products
        this.totalCategoriesGauge = Gauge.builder("categories_total", categoryRepository::count)
                .description("Total number of categories")
                .register(meterRegistry);
    }

}
