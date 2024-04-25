/*
    Copyright (c) $today.year The Culture Trip Inc. All rights reserved.
    This source file can not be copied and/or distributed without the express
    written permission of The Culture Trip Inc. Any unauthorized use is subject to criminal prosecution.
*/

package com.charmwithjava.testservice.core.data;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Created by Maneva.
 * @since 11.4.24.
 */
public interface ProductsRepository extends JpaRepository<ProductEntity, String> {

    ProductEntity findByProductId(String productId);
    ProductEntity findByProductIdOrTitle(String productId, String title);


}
