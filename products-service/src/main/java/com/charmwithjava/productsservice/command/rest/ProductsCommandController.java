package com.charmwithjava.productsservice.command.rest;

import com.charmwithjava.productsservice.command.CreateProductRestModel;
import com.charmwithjava.productsservice.core.data.CreateProduct;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductsCommandController {

    private Environment env;
    private CommandGateway commandGateway;

    public ProductsCommandController(Environment env, CommandGateway commandGateway) {
        this.env = env;
        this.commandGateway = commandGateway;
    }

//    @GetMapping
//    public String getProducts() {
//        return "HTTP GEt all products on port " + env.getProperty("local.server.port");
//    }

    @PostMapping("/post")
    public String createProduct(@RequestBody CreateProductRestModel createProductRestModel) {
        return "HTTP POST handled: " + createProductRestModel.getTitle();
    }

    @PostMapping
    public String postProduct(@RequestBody CreateProduct createProduct) {
        CreateProductRestModel createProductRestModel = CreateProductRestModel.builder()
                .productId(UUID.randomUUID().toString())
                .title(createProduct.getTitle())
                .price(createProduct.getPrice())
                .quantity(createProduct.getQuantity())
                .build();
        String returnValue;
        try {
             returnValue = commandGateway.sendAndWait(createProductRestModel);
        }
        catch (Exception ex) {
            returnValue = ex.getLocalizedMessage();
        }

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
