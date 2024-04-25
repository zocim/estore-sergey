package com.charmwithjava.productsservice.query;

import com.charmwithjava.productsservice.core.data.ProductEntity;
import com.charmwithjava.productsservice.core.data.ProductRepository;
import com.charmwithjava.productsservice.query.rest.ProductRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductsQueryHandler {

    private ProductRepository productRepository;

//    public ProductsQueryHandler(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    @QueryHandler
    List<ProductRestModel> findProducts(FindProductsQuery query) {
        List<ProductRestModel> productsRest = new ArrayList<>();

        List<ProductEntity> storedProducts = productRepository.findAll();

        for(ProductEntity productEntity : storedProducts) {
            ProductRestModel productRestModel = new ProductRestModel();
            BeanUtils.copyProperties(productEntity, productRestModel);
            productsRest.add(productRestModel);
        }

        return  productsRest;
    }
}
