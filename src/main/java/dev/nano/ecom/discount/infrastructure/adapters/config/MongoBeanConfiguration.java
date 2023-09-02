package dev.nano.ecom.discount.infrastructure.adapters.config;

import dev.nano.ecom.discount.application.service.DiscountService;
import dev.nano.ecom.discount.domain.service.ProductService;
import dev.nano.ecom.discount.infrastructure.adapters.output.persistance.mongo.MongoProductPersistenceAdapter;
import dev.nano.ecom.discount.infrastructure.adapters.output.persistance.mongo.mapper.MongoProductMapper;
import dev.nano.ecom.discount.infrastructure.adapters.output.persistance.mongo.repository.MongoProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("mongo")
public class MongoBeanConfiguration {

    @Bean
    public MongoProductPersistenceAdapter mongoProductPersistenceAdapter(
            MongoProductRepository mongoProductRepository, MongoProductMapper mongoProductMapper, DiscountService discountService
    ) {
        return new MongoProductPersistenceAdapter(mongoProductRepository, mongoProductMapper, discountService);
    }

    @Bean
    public ProductService productService(
            MongoProductPersistenceAdapter mongoProductPersistenceAdapter
    ) {
        return new ProductService(mongoProductPersistenceAdapter);
    }
}
