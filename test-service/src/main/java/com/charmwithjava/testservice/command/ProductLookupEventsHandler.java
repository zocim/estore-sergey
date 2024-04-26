/*
    Copyright (c) $today.year The Culture Trip Inc. All rights reserved.
    This source file can not be copied and/or distributed without the express
    written permission of The Culture Trip Inc. Any unauthorized use is subject to criminal prosecution.
*/

package com.charmwithjava.testservice.command;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.charmwithjava.testservice.core.data.ProductLookupEntity;
import com.charmwithjava.testservice.core.data.ProductLookupRepository;
import com.charmwithjava.testservice.core.events.ProductCreatedEvent;

/**
 * @author Created by Maneva.
 * @since 26.4.24.
 */

@Component
@ProcessingGroup("product-group")
public class ProductLookupEventsHandler {

    private ProductLookupRepository productLookupRepository;

    public ProductLookupEventsHandler(final ProductLookupRepository productLookupRepository) {
        this.productLookupRepository = productLookupRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent event) {
        ProductLookupEntity productLookupEntity = new ProductLookupEntity(event.getProductId(), event.getTitle());
        productLookupRepository.save(productLookupEntity);
    }
}
