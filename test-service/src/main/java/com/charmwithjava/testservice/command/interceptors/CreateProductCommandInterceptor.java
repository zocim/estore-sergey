/*
    Copyright (c) $today.year The Culture Trip Inc. All rights reserved.
    This source file can not be copied and/or distributed without the express
    written permission of The Culture Trip Inc. Any unauthorized use is subject to criminal prosecution.
*/

package com.charmwithjava.testservice.command.interceptors;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.BiFunction;
import javax.annotation.Nonnull;

import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.charmwithjava.testservice.command.CreateProductCommand;
import com.charmwithjava.testservice.core.data.ProductLookupEntity;
import com.charmwithjava.testservice.core.data.ProductLookupRepository;

/**
 * @author Created by Maneva.
 * @since 26.4.24.
 */

@Component
public class CreateProductCommandInterceptor implements MessageDispatchInterceptor<CommandMessage<?>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateProductCommandInterceptor.class);
    private ProductLookupRepository productLookupRepository;

    public CreateProductCommandInterceptor(final ProductLookupRepository productLookupRepository) {
        this.productLookupRepository = productLookupRepository;
    }

    //@Nonnull
    @Override
    public BiFunction<Integer, CommandMessage<?>, CommandMessage<?>> handle(
        @Nonnull final List<? extends CommandMessage<?>> messages) {

        return (index, command) -> {
            if(CreateProductCommand.class.equals(command.getPayloadType())) {

                LOGGER.info("Intercepted command: " + command.getPayloadType());
                CreateProductCommand createProductCommand = (CreateProductCommand) command;

                ProductLookupEntity productLookupEntity = productLookupRepository.findByProductIdOrTitle(
                    createProductCommand.getProductId(),
                    createProductCommand.getTitle());

                if(productLookupEntity != null) {
                    throw new IllegalArgumentException(
                        String.format("Product with productId %s or title %s already existed.",
                            productLookupEntity.getProductId(), productLookupEntity.getTitle())
                    );
                }
                // if(createProductCommand.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
                //     throw new IllegalArgumentException("Price can not be less or equal than zero");
                // }
                //
                // if(createProductCommand.getTitle() == null ||
                //    createProductCommand.getTitle().isBlank()) {
                //     throw new IllegalArgumentException("Title cannot be empty");
                // }
            }
            return command;
        };
    }
}
