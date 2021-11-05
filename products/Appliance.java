package com.ivanboyukliev.products;

import com.ivanboyukliev.discountcalculators.ApplianceDiscount;
import com.ivanboyukliev.discountcalculators.DiscountCalculator;
import com.ivanboyukliev.products.abstractions.Product;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

import static com.ivanboyukliev.utils.ApplicationConstants.CURRENCY_SYMBOL;

public class Appliance extends Product {

    private String model;
    private LocalDate productionDate;
    private float weight;

    public Appliance(String name, String brand, float price, String model,
                     LocalDate productionDate, float weight) {
        super(name, brand, price);
        this.model = model;
        this.productionDate = productionDate;
        this.weight = weight;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public float getDiscount(LocalDateTime purchaseDateTime) {
        DiscountCalculator discountCalculator = ApplianceDiscount.getInstance();
        return discountCalculator.calculateDiscount(purchaseDateTime, this);
    }

    @Override
    public String toString() {
        // Appliances should have non-fractional values for quantity
        String quantityAsInt = String.format(Locale.ROOT,"%.0f",quantity);
        return name + " " + brand + " " +
               model + "\n" + quantityAsInt + " x " +
               CURRENCY_SYMBOL + price + " = " +
               CURRENCY_SYMBOL + (quantity * price);
    }
}
