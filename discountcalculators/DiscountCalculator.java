package com.ivanboyukliev.discountcalculators;

import com.ivanboyukliev.products.abstractions.Product;

import java.time.LocalDateTime;

public interface DiscountCalculator {

    float calculateDiscount(LocalDateTime purchaseDateTime, Product product);
}
