package com.charmwithjava.productsservice.core.data;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProduct {
    private String title;
    private BigDecimal price;
    private Integer quantity;

}
