package com.charmwithjava.testservice.command.rest;

import java.math.BigDecimal;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateProductRestModel {
    @NotBlank(message = "Product title is required")
    private String title;

    @Min(value = 1, message = "Price can not be lower than 1")
    private BigDecimal price;

    @Min(value = 1, message = "Quantity can not be lower than 1")
    @Max(value = 15, message = "Quantity can not be larger than 15")
    private Integer quantity;

}
