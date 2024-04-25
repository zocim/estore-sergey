package com.charmwithjava.productsservice.core.data;

import com.charmwithjava.productsservice.core.data.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    Optional<ProductEntity> findByProductId(String productId);
    Optional<ProductEntity> findByProductIdOrTitle(String productId, String title);

}
