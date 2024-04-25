/*
    Copyright (c) $today.year The Culture Trip Inc. All rights reserved.
    This source file can not be copied and/or distributed without the express
    written permission of The Culture Trip Inc. Any unauthorized use is subject to criminal prosecution.
*/

package com.charmwithjava.testservice.query;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.charmwithjava.testservice.core.data.ProductEntity;
import com.charmwithjava.testservice.core.data.ProductsRepository;
import com.charmwithjava.testservice.core.events.ProductCreatedEvent;

/**
 * @author Created by Maneva.
 * @since 11.4.24.
 */

@Component
public class ProductEventHandler {

    private ProductsRepository productsRepository;

    @Autowired
    public ProductEventHandler(final ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent productCreatedEvent) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(productCreatedEvent, productEntity);
        productsRepository.save(productEntity);
    }
}
