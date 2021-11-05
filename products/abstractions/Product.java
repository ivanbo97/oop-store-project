package com.ivanboyukliev.products.abstractions;

import java.time.LocalDateTime;

public abstract class Product {

    protected String name;
    protected String brand;
    protected float price;
    protected float quantity;

    public Product(String name, String brand, float price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public abstract float getDiscount(LocalDateTime purchaseDateTime);
}
