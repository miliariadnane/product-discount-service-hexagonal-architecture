package dev.nano.ecom.discount.commons.data;

import dev.nano.ecom.discount.infrastructure.adapters.output.persistance.mongo.entity.MongoProductEntity;
import dev.nano.ecom.discount.infrastructure.adapters.output.persistance.mongo.repository.MongoProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.UUID;

@Configuration
@Profile("mongo")
public class ProductMongoDbSeeder {

    @Bean
    CommandLineRunner initDatabase(MongoProductRepository mongoProductRepository) {
        return args -> {
            for (int i = 0; i < 30; i++) {
                mongoProductRepository.save(new MongoProductEntity(
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
