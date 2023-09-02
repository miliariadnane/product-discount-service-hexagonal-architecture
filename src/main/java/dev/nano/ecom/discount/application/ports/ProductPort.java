package dev.nano.ecom.discount.application.ports;

import dev.nano.ecom.discount.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductPort {
    void addProduct(Product product);
    void removeProduct(Product product);
    List<Product> getProducts();
    Optional<Product> getProductById(String productId);
}
