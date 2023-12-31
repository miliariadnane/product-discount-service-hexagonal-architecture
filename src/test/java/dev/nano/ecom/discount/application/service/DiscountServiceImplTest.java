package dev.nano.ecom.discount.application.service;

import dev.nano.ecom.discount.domain.enumeration.Category;
import dev.nano.ecom.discount.domain.enumeration.Manufacture;
import dev.nano.ecom.discount.domain.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountServiceImplTest {

    private DiscountServiceImpl discountService;

    @BeforeEach
    void setUp() {
        discountService = new DiscountServiceImpl();
    }

    @Test
    void should_return_discounted_price_when_product_is_fashion_or_beauty() {
        // given
        var product = new Product(
                "BE-01-87",
                "Argan oil",
                "Argan oil facial cream",
                Category.BEAUTY,
                Manufacture.L_OREAL,
                100,
                5
        );

        // when
        var discountedPrice = discountService.calculateDiscountedPrice(product);

        // then
        assertEquals(100, discountedPrice);
    }

    @Test
    void should_return_six_percent_discounted_price_when_product_in_electronics_and_manufactured_by_apple() {
        // given
        var product = new Product(
                "EL-02-10",
                "iPhone 12",
                "iPhone 12 128GB",
                Category.ELECTRONICS,
                Manufacture.APPLE,
                8500,
                10
        );

        var discountedPrice = discountService.calculateDiscountedPrice(product);

        assertEquals(7990, discountedPrice);
    }

    @Test
    void should_return_eight_percent_discounted_price_when_product_in_electronics_and_manufactured_by_samsung() {
        var product = new Product(
                "EL-02-11",
                "Galaxy S21",
                "Galaxy S21 256GB",
                Category.ELECTRONICS,
                Manufacture.SAMSUNG,
                7000,
                7
        );

        var discountedPrice = discountService.calculateDiscountedPrice(product);

        assertEquals(6440, discountedPrice);
    }

    @Test
    void should_return_ten_percent_discounted_price_when_product_in_electronics_and_manufactured_by_other_than_apple_or_samsung() {
        var product = new Product(
                "EL-03-12",
                "Paystation 5",
                "Paystation 5 1TB",
                Category.ELECTRONICS,
                Manufacture.SONY,
                5000,
                5
        );

        var discountedPrice = discountService.calculateDiscountedPrice(product);

        assertEquals(4500, discountedPrice);
    }

    @Test
    void should_return_twenty_five_percent_discounted_price_when_product_in_sports_and_manufactured_by_nike() {
        var product = new Product(
                "SP-04-13",
                "Air Jordan 1",
                "Air Jordan 1 Retro High OG",
                Category.SPORTS,
                Manufacture.NIKE,
                3500,
                4
        );

        var discountedPrice = discountService.calculateDiscountedPrice(product);

        assertEquals(2625, discountedPrice);
    }

    @Test
    void should_return_twenty_percent_discounted_price_when_product_in_sports_and_manufactured_by_other_than_nike() {
        var product = new Product(
                "SP-04-14",
                "Adidas Boost",
                "Adidas Boost 350 V2 Zebra 2020",
                Category.SPORTS,
                Manufacture.ADIDAS,
                4000,
                9
        );

        var discountedPrice = discountService.calculateDiscountedPrice(product);

        assertEquals(3200, discountedPrice);
    }

    @Test
    @Disabled
    void should_return_fifty_percent_discounted_price_when_product_in_books_and_today_is_black_friday_5th_of_november() {
        Product product = new Product(
                "BK-05-15",
                "Build Microservices",
                "Build Microservices with Spring Boot",
                Category.BOOKS,
                Manufacture.IN_ACTION,
                300,
                15
        );

        double discountedPrice = discountService.calculateDiscountedPrice(product);

        assertEquals(150, discountedPrice);
    }

    @Test
    void should_return_forty_percent_discounted_price_when_product_in_books_and_today_is_not_black_friday() {
        Product product = new Product(
                "BK-05-17",
                "The Lord of the Rings",
                "The Lord of the Rings: The Fellowship of the Ring",
                Category.BOOKS,
                Manufacture.O_RELLY,
                250,
                25
        );

        double discountedPrice = discountService.calculateDiscountedPrice(product);

        assertEquals(150, discountedPrice);
    }

    @Test
    void should_return_default_discounted_price_for_default_case() {
        Product product = new Product(
                "OTH-05-01",
                "Other",
                "Other product",
                Category.OTHERS,
                Manufacture.OTHERS,
                250,
                3
        );

        double discountedPrice = discountService.calculateDiscountedPrice(product);

        assertEquals(237.5, discountedPrice);
    }
}
