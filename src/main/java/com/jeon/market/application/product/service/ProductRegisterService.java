package com.jeon.market.application.product.service;

import com.jeon.market.application.product.domain.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductRegisterService {

    private final ProductRepository productRepository;

    public ProductRegisterService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductRegisterResponse register(ProductRegisterRequest request) {
        // 1. 유효한 고객인지 체크.

        // 2. 상품정보 등록

        return null;
    }


}
