package com.jeon.market.product.domain;

import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);

    Optional<Product> findById(Long productId);
}
