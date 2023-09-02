package dev.nano.ecom.discount.domain.service;

import dev.nano.ecom.discount.application.ports.ProductPort;
import dev.nano.ecom.discount.commons.exception.domain.ProductNotFoundException;
import dev.nano.ecom.discount.domain.model.Product;

import java.util.List;

import static dev.nano.ecom.discount.commons.constant.ExceptionConstant.NO_PRODUCT_FOUND_MSG;

public class ProductService {

    private final ProductPort productPort;

    public ProductService(ProductPort productPort) {
        this.productPort = productPort;
    }

    public void addProduct(Product product) {
        productPort.addProduct(product);
    }

    public void removeProduct(Product product) {
        productPort.removeProduct(product);
    }

    public List<Product> getProducts() {
        return productPort.getProducts();
    }

    public Product getProductById(String productId) {
        return productPort.getProductById(productId)
                .orElseThrow(() -> new ProductNotFoundException(
                        NO_PRODUCT_FOUND_MSG + productId
                ));
    }
}
