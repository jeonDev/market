package com.jeon.market.application.product.usecase;

import com.jeon.market.application.product.domain.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductRegisterService {

    private final ProductRepository productRepository;

    public ProductRegisterService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void register() {

    }


}
