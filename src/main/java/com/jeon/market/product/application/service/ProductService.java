package com.jeon.market.product.application.service;

import com.jeon.market.product.application.domain.Product;
import com.jeon.market.product.application.domain.ProductRepository;
import com.jeon.market.product.application.service.request.ProductRegisterRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product register(ProductRegisterRequest request) {
        return productRepository.save(request.toEntity());
    }

    @Transactional
    public void transactionComplete(Product product) {
        product.transactionComplete();
        productRepository.save(product);
    }
}
