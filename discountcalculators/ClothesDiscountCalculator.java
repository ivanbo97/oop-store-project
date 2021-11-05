package com.ivanboyukliev.discountcalculators;

import com.ivanboyukliev.products.abstractions.Product;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static java.time.DayOfWeek.*;


public class ClothesDiscountCalculator implements DiscountCalculator {

    private final float workingDaysDiscount = 0.1f;

    // Using Bill Pugh approach for implementing Singleton Pattern

    private ClothesDiscountCalculator() {
    }

    private static class SingletonHelper {
        private static final ClothesDiscountCalculator uniqueInstance = new ClothesDiscountCalculator();
    }

    public static ClothesDiscountCalculator getInstance() {
        return SingletonHelper.uniqueInstance;
    }

    @Override
    public float calculateDiscount(LocalDateTime purchaseDateTime, Product product) {

        DayOfWeek purchaseDay = purchaseDateTime.getDayOfWeek();
        if (purchaseDay != SATURDAY && purchaseDay != SUNDAY) {
            return product.getPrice() * workingDaysDiscount;
        }
        return 0;
    }
}
