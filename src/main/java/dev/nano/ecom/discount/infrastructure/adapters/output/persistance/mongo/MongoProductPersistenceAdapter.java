package dev.nano.ecom.discount.infrastructure.adapters.output.persistance.mongo;

import dev.nano.ecom.discount.application.ports.ProductPort;
import dev.nano.ecom.discount.application.service.DiscountService;
import dev.nano.ecom.discount.domain.model.Product;
import dev.nano.ecom.discount.infrastructure.adapters.output.persistance.mongo.entity.MongoProductEntity;
import dev.nano.ecom.discount.infrastructure.adapters.output.persistance.mongo.mapper.MongoProductMapper;
import dev.nano.ecom.discount.infrastructure.adapters.output.persistance.mongo.repository.MongoProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class MongoProductPersistenceAdapter implements ProductPort {

    private final MongoProductRepository mongoProductRepository;
    private final MongoProductMapper mongoProductMapper;
    private final DiscountService discountService;

    @Override
    public void addProduct(Product product) {
        double discountedPrice = discountService.calculateDiscountedPrice(product);
        MongoProductEntity mongoProductEntity = mongoProductMapper.toEntity(product);
        mongoProductEntity.setPrice(discountedPrice);
        mongoProductRepository.save(mongoProductEntity);
    }

    @Override
    public void removeProduct(Product product) {
        MongoProductEntity entity = mongoProductMapper.toEntity(product);
        mongoProductRepository.delete(entity);
    }

    @Override
    public List<Product> getProducts() {
        List<MongoProductEntity> mongoProductEntityList = mongoProductRepository.findAll();
        return mongoProductEntityList.stream()
                .map(mongoProductMapper::entityToProduct)
                .toList();
    }

    @Override
    public Optional<Product> getProductById(String productId) {
        Optional<MongoProductEntity> productEntity =
                mongoProductRepository.findById(productId);

        if(productEntity.isEmpty()) {
            return Optional.empty();
        }

        Product product = mongoProductMapper.entityToProduct(productEntity.get());
        return Optional.of(product);
    }
}
