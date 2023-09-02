package dev.nano.ecom.discount.application.service;

import dev.nano.ecom.discount.domain.enumeration.Manufacture;
import dev.nano.ecom.discount.domain.model.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DiscountServiceImpl implements DiscountService {

    private static final double DEFAULT_DISCOUNT_RATE = 0.05;

    @Override
    public double calculateDiscountedPrice(Product product) {
        double discount;
        switch (product.category()) {
            case FASHION, BEAUTY -> discount = 0;
            case ELECTRONICS -> {
                if (product.manufacture() == Manufacture.APPLE) {
                    discount = 0.06;
                } else if (product.manufacture() == Manufacture.SAMSUNG) {
                    discount = 0.08;
                } else {
                    discount = 0.1;
                }
            }
            case SPORTS -> discount = product.manufacture() == Manufacture.NIKE ? 0.25 : 0.2;
            case BOOKS -> discount = isBlackFriday() ? 0.5 : 0.4;
            default -> discount = DEFAULT_DISCOUNT_RATE;

        }
        return product.price() - (product.price() * discount);
    }

    private boolean isBlackFriday() {
        LocalDate date = LocalDate.now();
        return date.getMonthValue() == 11 && date.getDayOfMonth() == 5;
    }
}
