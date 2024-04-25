package com.charmwithjava.productsservice.query;

import com.charmwithjava.productsservice.core.events.ProductCreatedEvent;
import com.charmwithjava.productsservice.core.data.ProductEntity;
import com.charmwithjava.productsservice.core.data.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductEventsHandler {

    ProductRepository productRepository;

    //public ProductEventsHandler(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    @EventHandler
    public void on(ProductCreatedEvent event) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(event, productEntity);

        //productRepository.save(productEntity);
    }
}
