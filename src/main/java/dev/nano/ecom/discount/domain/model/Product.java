package dev.nano.ecom.discount.domain.model;

import dev.nano.ecom.discount.domain.enumeration.Category;
import dev.nano.ecom.discount.domain.enumeration.Manufacture;

public record Product (
        String id, String name, String description, Category category, Manufacture manufacture, double price, int quantity
) {
}
