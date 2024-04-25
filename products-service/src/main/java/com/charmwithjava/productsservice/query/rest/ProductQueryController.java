package com.charmwithjava.productsservice.query.rest;


import com.charmwithjava.productsservice.core.data.ProductEntity;
import com.charmwithjava.productsservice.query.FindProductsQuery;
import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductQueryController {

    QueryGateway queryGateway;

    public ProductQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

//    @GetMapping
//    public List<ProductRestModel> getProduct() {
//        FindProductsQuery findProductsQuery = new FindProductsQuery();
//        List<ProductRestModel> productRestModels =
//                queryGateway.query(findProductsQuery,
//                        ResponseTypes.multipleInstancesOf(ProductRestModel.class)).join();
//        return productRestModels;
//    }

    @GetMapping("/productId")
    public ProductEntity getProduct(@PathVariable String productId) {
        return null;
    }

    @GetMapping
    public String getProducts() {
        return "HTTP GET All products";
    }
}
