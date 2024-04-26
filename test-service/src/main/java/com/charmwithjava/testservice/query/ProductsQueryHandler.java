/*
    Copyright (c) $today.year The Culture Trip Inc. All rights reserved.
    This source file can not be copied and/or distributed without the express
    written permission of The Culture Trip Inc. Any unauthorized use is subject to criminal prosecution.
*/

package com.charmwithjava.testservice.query;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.charmwithjava.testservice.core.data.ProductEntity;
import com.charmwithjava.testservice.core.data.ProductsRepository;
import com.charmwithjava.testservice.query.rest.ProductRestModel;

/**
 * @author Created by Maneva.
 * @since 26.4.24.
 */
@Component
public class ProductsQueryHandler {

    private ProductsRepository productsRepository;

    public ProductsQueryHandler(final ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @QueryHandler
    public List<ProductRestModel> findProducts(FindProductsQuery findProductsQuery) {
        List<ProductRestModel> products = new ArrayList<>();
        List<ProductEntity> productEntities = productsRepository.findAll();
        for(ProductEntity productEntity: productEntities) {
            ProductRestModel productRestModel = new ProductRestModel();
            BeanUtils.copyProperties(productEntity, productRestModel);
            products.add(productRestModel);
        }

        return products;
    }
}
