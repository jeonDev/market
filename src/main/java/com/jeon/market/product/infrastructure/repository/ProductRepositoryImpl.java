package com.jeon.market.product.infrastructure.repository;

import com.jeon.market.product.domain.Product;
import com.jeon.market.product.domain.ProductRepository;
import com.jeon.market.product.infrastructure.repository.jpa.JpaProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final JpaProductRepository jpaProductRepository;

    public ProductRepositoryImpl(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return jpaProductRepository.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long productId) {
        return jpaProductRepository.findById(productId);
    }
}
