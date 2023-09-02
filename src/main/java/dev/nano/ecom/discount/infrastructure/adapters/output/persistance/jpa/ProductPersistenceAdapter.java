package dev.nano.ecom.discount.infrastructure.adapters.output.persistance.jpa;

import dev.nano.ecom.discount.application.ports.ProductPort;
import dev.nano.ecom.discount.application.service.DiscountService;
import dev.nano.ecom.discount.domain.model.Product;
import dev.nano.ecom.discount.infrastructure.adapters.output.persistance.jpa.entity.ProductEntity;
import dev.nano.ecom.discount.infrastructure.adapters.output.persistance.jpa.mapper.ProductMapper;
import dev.nano.ecom.discount.infrastructure.adapters.output.persistance.jpa.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductPort {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final DiscountService discountService;

    @Override
    public void addProduct(Product product) {
        ProductEntity productEntity = productMapper.toEntity(product);
        productRepository.save(productEntity);
    }

    @Override
    public void removeProduct(Product product) {
        double discountedPrice = discountService.calculateDiscountedPrice(product);
        ProductEntity productEntity = productMapper.toEntity(product);
        productEntity.setPrice(discountedPrice);
        productRepository.delete(productEntity);
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        List<ProductEntity> productEntityList = productRepository.findAll();
        for(ProductEntity productEntity : productEntityList) {
            Product product = productMapper.entityToProduct(productEntity);
            products.add(product);
        }
        return products;
    }

    @Override
    public Optional<Product> getProductById(String productId) {
        Optional<ProductEntity> productEntity =
                productRepository.findById(productId);

        if(productEntity.isEmpty()) {
            return Optional.empty();
        }

        Product product = productMapper.entityToProduct(productEntity.get());
        return Optional.of(product);
    }
}
