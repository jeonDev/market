package com.jeon.market.application.product.infrastructure;

import com.jeon.market.application.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<Product, Long> {
}
