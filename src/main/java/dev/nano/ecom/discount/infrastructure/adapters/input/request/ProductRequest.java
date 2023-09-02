package dev.nano.ecom.discount.infrastructure.adapters.input.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductRequest {

    @NotNull(message="name is required")
    @Size(min=3, message ="name should have 3 characters minimum")
    private String name;


    private String description;

    @NotNull(message="category is required")
    private String category;

    @NotNull(message="Manufacturer is required")
    private String manufacture;

    @NotNull(message="price is required")
    @Positive(message = "price should be positive")
    private double price;

    @NotNull(message="quantity is required")
    @PositiveOrZero(message = "quantity should be positive or zero")
    private int quantity;
}
