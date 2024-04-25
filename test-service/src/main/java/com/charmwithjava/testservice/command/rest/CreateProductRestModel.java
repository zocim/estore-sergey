package com.charmwithjava.testservice.command.rest;

import java.math.BigDecimal;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateProductRestModel {
    private String title;
    private BigDecimal price;
    private Integer quantity;

}
