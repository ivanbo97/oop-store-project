package com.ivanboyukliev;

import com.ivanboyukliev.products.abstractions.Product;
import com.ivanboyukliev.utils.PercentageCalculator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.ivanboyukliev.utils.ApplicationConstants.*;

public class Cashier {

    public void printReceipt(ShoppingCart<Product> cart, LocalDateTime purchaseDateTime) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Date: " + purchaseDateTime.format(dateTimeFormatter) + "\n");
        System.out.print(PRODUCTS_LABEL);

        float totalDiscount = 0.0f;
        float totalSum = 0.0f;

        for (Product product : cart.getProducts()) {
            System.out.println("\n\n");
            System.out.print(product);
            float productDiscount = product.getDiscount(purchaseDateTime);
            totalSum += product.getPrice() * product.getQuantity();
            if (productDiscount == 0.0) {
                continue;
            }
            float discountForMultipleProd = productDiscount * product.getQuantity();
            String discountStr = String.format(Locale.ROOT, "%.2f", discountForMultipleProd);

            int discountInPercentage = (int) PercentageCalculator.calculatePercentage(productDiscount,
                    product.getPrice());

            System.out.print("\n" + DISCOUNT_LABEL + " " +
                    discountInPercentage + "% -" + CURRENCY_SYMBOL + discountStr);

            totalDiscount += discountForMultipleProd;
        }

        System.out.println("\n" + TERMINATION_LABEL + "\n");

        String totalSumStr = String.format(Locale.ROOT, "%.2f", totalSum);
        System.out.println("SUBTOTAL: " + CURRENCY_SYMBOL + totalSumStr);

        String totalDiscountStr = String.format(Locale.ROOT, "%.2f", totalDiscount);
        System.out.println("DISCOUNT: -" + CURRENCY_SYMBOL + totalDiscountStr + "\n");

        String total = String.format(Locale.ROOT, "%.2f", totalSum - totalDiscount);
        System.out.println("TOTAL: " + CURRENCY_SYMBOL + total);
    }
}
