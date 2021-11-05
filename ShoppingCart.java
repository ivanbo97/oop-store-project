package com.ivanboyukliev;

import com.ivanboyukliev.products.abstractions.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart<T extends Product> {

    private List<T> products;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public ShoppingCart(List<T> products) {
        this.products = products;
    }

    public void addProduct(T newProduct) {
        products.add(newProduct);
    }

    public void removeProduct(T product) {
        products.remove(product);
    }

    public List<T> getProducts() {
        return products;
    }
}
