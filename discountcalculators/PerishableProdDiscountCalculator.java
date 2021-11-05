package com.ivanboyukliev.discountcalculators;

import com.ivanboyukliev.products.abstractions.Perishable;
import com.ivanboyukliev.products.abstractions.Product;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class PerishableProdDiscountCalculator implements DiscountCalculator {

    private final float discountAtExpirationDate = 0.5f;
    private final float discountWithinDayRange = 0.1f;
    private final int neededDaysForDiscount = 5;

    // Using Bill Pugh approach for implementing Singleton Pattern

    private PerishableProdDiscountCalculator() {
    }

    private static class SingletonHelper {
        private static PerishableProdDiscountCalculator uniqueInstance = new PerishableProdDiscountCalculator();
    }

    public static PerishableProdDiscountCalculator getInstance() {
        return SingletonHelper.uniqueInstance;
    }

    @Override
    public float calculateDiscount(LocalDateTime purchaseDateTime, Product product) {
        LocalDate purchasedDate = purchaseDateTime.toLocalDate();
        LocalDate expirationDate = ((Perishable) product).getExpirationDate();

        if (purchasedDate.compareTo(expirationDate) == 0) {
            return product.getPrice() * discountAtExpirationDate;
        }

        long daysUntilExpiration = ChronoUnit.DAYS.between(purchasedDate, expirationDate);
        if (daysUntilExpiration <= neededDaysForDiscount) {
            return product.getPrice() * discountWithinDayRange;
        }
        return 0;
    }
}
