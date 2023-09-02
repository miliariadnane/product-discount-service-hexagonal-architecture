package dev.nano.ecom.discount.commons.data;

import com.github.javafaker.Faker;
import dev.nano.ecom.discount.domain.enumeration.Category;
import dev.nano.ecom.discount.domain.enumeration.Manufacture;

public class DataGenerator {
    private static final Faker faker = new Faker();

    public static String generateProductName() {
        return faker.commerce().productName();
    }

    public static String generateDescription() {
        return faker.lorem().sentence();
    }

    public static Category generateCategory() {
        return faker.options().option(Category.class);
    }

    public static Manufacture generateManufacture() {
        return faker.options().option(Manufacture.class);
    }

    public static double generatePrice() {
        return Double.parseDouble(faker.commerce().price());
    }

    public static int generateQuantity() {
        return faker.number().numberBetween(1, 250);
    }
}
