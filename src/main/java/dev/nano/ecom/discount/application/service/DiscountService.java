package dev.nano.ecom.discount.application.service;

import dev.nano.ecom.discount.domain.model.Product;

public interface DiscountService {
    double calculateDiscountedPrice(Product product);
}
