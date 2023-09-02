package dev.nano.ecom.discount.infrastructure.adapters.config;

import dev.nano.ecom.discount.application.service.DiscountService;
import dev.nano.ecom.discount.domain.service.ProductService;
import dev.nano.ecom.discount.infrastructure.adapters.output.persistance.jpa.ProductPersistenceAdapter;
import dev.nano.ecom.discount.infrastructure.adapters.output.persistance.jpa.mapper.ProductMapper;
import dev.nano.ecom.discount.infrastructure.adapters.output.persistance.jpa.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("jpa")
public class JpaBeanConfiguration {

    @Bean
    public ProductPersistenceAdapter productPersistenceAdapter(
            ProductRepository productRepository, ProductMapper productMapper, DiscountService discountService
    ) {
        return new ProductPersistenceAdapter(productRepository, productMapper, discountService);
    }

    @Bean
    public ProductService productService(
            ProductPersistenceAdapter productPersistenceAdapter
    ) {
        return new ProductService(productPersistenceAdapter);
    }
}
