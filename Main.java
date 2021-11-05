package com.ivanboyukliev;

import com.ivanboyukliev.products.*;
import com.ivanboyukliev.products.abstractions.Product;
import com.ivanboyukliev.utils.ClothesSize;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        ShoppingCart<Product> shoppingCart = new ShoppingCart<>();

        Appliance laptop = new Appliance("laptop","BrandL",2345,"ModelL",
                LocalDate.of(2021,3,3),1.125f);
        laptop.setQuantity(1);

        Clothes tShirt = new Clothes("T-shirt","BrandT",15.99f, ClothesSize.M,"violet");
        tShirt.setQuantity(2);

        Beverage milk = new Beverage("milk","BrandM",0.99f,LocalDate.of(2022,2,2));
        milk.setQuantity(3);

        Food apples = new Food("apples","BrandA",1.50f,LocalDate.of(2021,6,14));
        apples.setQuantity(2.45f);

        shoppingCart.addProduct(apples);
        shoppingCart.addProduct(milk);
        shoppingCart.addProduct(tShirt);
        shoppingCart.addProduct(laptop);

        Cashier cashier = new Cashier();
        cashier.printReceipt(shoppingCart, LocalDateTime.of(2021,6,14,12,34,56));

    }
}
