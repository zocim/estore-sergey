/*
    Copyright (c) $today.year The Culture Trip Inc. All rights reserved.
    This source file can not be copied and/or distributed without the express
    written permission of The Culture Trip Inc. Any unauthorized use is subject to criminal prosecution.
*/

package com.charmwithjava.testservice.core.events;

import java.math.BigDecimal;

import lombok.Data;

/**
 * @author Created by Maneva.
 * @since 11.4.24.
 */
@Data
public class ProductCreatedEvent {

    private String productId;
    private String title;
    private BigDecimal price;
    private Integer quantity;

}
