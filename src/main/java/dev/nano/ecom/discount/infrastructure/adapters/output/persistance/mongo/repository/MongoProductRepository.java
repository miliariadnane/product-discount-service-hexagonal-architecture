package dev.nano.ecom.discount.infrastructure.adapters.output.persistance.mongo.repository;

import dev.nano.ecom.discount.infrastructure.adapters.output.persistance.mongo.entity.MongoProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoProductRepository extends MongoRepository<MongoProductEntity, String> {
}
