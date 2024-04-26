package com.charmwithjava.testservice.command.rest;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charmwithjava.testservice.command.CreateProductCommand;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/products")
public class ProductsCommandController {

    private final Environment env;
    private final CommandGateway commandGateway;

    @Autowired
    public ProductsCommandController(final Environment env, final CommandGateway commandGateway) {
        this.env = env;
        this.commandGateway = commandGateway;
    }

    //    @GetMapping
//    public String getProducts() {
//        return "HTTP GEt all products on port " + env.getProperty("local.server.port");
//    }

    @PostMapping
    public String createProduct(@Valid @RequestBody CreateProductRestModel createProductRestModel) {
        CreateProductCommand createProductCommand = CreateProductCommand.builder()
            .productId(UUID.randomUUID().toString())
            .title(createProductRestModel.getTitle())
            .price(createProductRestModel.getPrice())
            .quantity(createProductRestModel.getQuantity())
            .build();

        String returnValue;
        // try {
        //      returnValue = commandGateway.sendAndWait(createProductCommand);
        // }
        // catch (Exception ex) {
        //     return ex.getLocalizedMessage();
        // }

        returnValue = commandGateway.sendAndWait(createProductCommand);
        return returnValue;
    }

    @PutMapping
    public String putProduct() {
        return "HTTP PUT product";
    }

    @DeleteMapping
    public String deleteProduct() {
        return "HTTP DELETE product";
    }
}
