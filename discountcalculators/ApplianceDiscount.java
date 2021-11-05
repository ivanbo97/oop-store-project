package com.ivanboyukliev.discountcalculators;

import com.ivanboyukliev.products.abstractions.Product;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

public class ApplianceDiscount implements DiscountCalculator {

    private final float priceAndWeekendDiscount = 0.05f;

    // Using Bill Pugh approach for implementing Singleton Pattern

    private ApplianceDiscount(){
    }

    private static class SingletonHelper {
        private static final ApplianceDiscount uniqueInstance = new ApplianceDiscount();
    }

    public static ApplianceDiscount getInstance() {
        return SingletonHelper.uniqueInstance;
    }

    @Override
    public float calculateDiscount(LocalDateTime purchaseDateTime, Product product) {

        DayOfWeek purchaseDay = purchaseDateTime.getDayOfWeek();
        float productPrice = product.getPrice();
        if ((purchaseDay == SATURDAY || purchaseDay == SUNDAY) && productPrice > 999) {
            return product.getPrice() * priceAndWeekendDiscount;
        }
        return 0;
    }
}
