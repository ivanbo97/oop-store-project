package com.ivanboyukliev.products;

import com.ivanboyukliev.discountcalculators.DiscountCalculator;
import com.ivanboyukliev.discountcalculators.PerishableProdDiscountCalculator;
import com.ivanboyukliev.products.abstractions.Perishable;
import com.ivanboyukliev.products.abstractions.Product;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

import static com.ivanboyukliev.utils.ApplicationConstants.CURRENCY_SYMBOL;

public class Food extends Product implements Perishable {

    private LocalDate expirationDate;

    public Food(String name, String brand, float price, LocalDate expirationDate) {
        super(name, brand, price);
        this.expirationDate = expirationDate;
    }

    @Override
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Override
    public float getDiscount(LocalDateTime purchaseDateTime) {
        DiscountCalculator discountCalculator = PerishableProdDiscountCalculator.getInstance();
        return discountCalculator.calculateDiscount(purchaseDateTime, this);
    }

    @Override
    public String toString() {
        String totalPriceFormatted = String.format(Locale.ROOT, "%.2f", quantity * price);
        return name + " - " + brand + "\n" +
               quantity + " x " + CURRENCY_SYMBOL + price + " = " +
               CURRENCY_SYMBOL + totalPriceFormatted;
    }
}
