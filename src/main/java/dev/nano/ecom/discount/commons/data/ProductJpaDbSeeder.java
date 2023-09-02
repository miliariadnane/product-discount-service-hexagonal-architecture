package dev.nano.ecom.discount.commons.data;

import dev.nano.ecom.discount.infrastructure.adapters.output.persistance.jpa.entity.ProductEntity;
import dev.nano.ecom.discount.infrastructure.adapters.output.persistance.jpa.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.UUID;

@Configuration
@Profile("jpa")
public class ProductJpaDbSeeder {

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository) {
        return args -> {
            for (int i = 0; i < 25; i++) {
                productRepository.save(new ProductEntity(
                        String.valueOf(UUID.randomUUID()),
                        DataGenerator.generateProductName(),
                        DataGenerator.generateDescription(),
                        DataGenerator.generateCategory(),
                        DataGenerator.generateManufacture(),
                        DataGenerator.generatePrice(),
                        DataGenerator.generateQuantity()
                ));
            }
        };
    }
}
