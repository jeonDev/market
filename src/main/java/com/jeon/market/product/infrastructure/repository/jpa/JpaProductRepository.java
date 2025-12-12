package com.jeon.market.product.infrastructure.repository.jpa;

import com.jeon.market.product.application.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<Product, Long> {
}
