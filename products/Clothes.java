package com.ivanboyukliev.products;

import com.ivanboyukliev.products.abstractions.Product;
import com.ivanboyukliev.utils.ClothesSize;
import com.ivanboyukliev.discountcalculators.ClothesDiscountCalculator;
import com.ivanboyukliev.discountcalculators.DiscountCalculator;

import java.time.LocalDateTime;
import java.util.Locale;

import static com.ivanboyukliev.utils.ApplicationConstants.CURRENCY_SYMBOL;

public class Clothes extends Product {

    private ClothesSize size;
    private String color;

    public Clothes(String name, String brand, float price, ClothesSize size, String color) {
        super(name, brand, price);
        this.size = size;
        this.color = color;
    }

    public ClothesSize getSize() {
        return size;
    }

    public void setSize(ClothesSize size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public float getDiscount(LocalDateTime purchaseDateTime) {
        DiscountCalculator discountCalculator = ClothesDiscountCalculator.getInstance();
        return discountCalculator.calculateDiscount(purchaseDateTime,this);
    }

    @Override
    public String toString() {
        // Clothes should have non-fractional values for quantity
        String quantityAsInt = String.format(Locale.ROOT,"%.0f",quantity);
        return name + " " + brand + " " + size.name() + " " +
               color + "\n" + quantityAsInt + " x " +
               CURRENCY_SYMBOL + price + " = " +
               CURRENCY_SYMBOL + (quantity * price);
    }
}
