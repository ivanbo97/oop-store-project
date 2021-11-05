package com.ivanboyukliev.products.abstractions;

import java.time.LocalDate;

public interface Perishable {

    LocalDate getExpirationDate();
}
