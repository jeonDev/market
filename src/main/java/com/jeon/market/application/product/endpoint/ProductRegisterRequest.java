package com.jeon.market.application.product.endpoint;

import com.jeon.market.application.product.service.ProductRegisterCommandRequest;

import java.math.BigInteger;

public record ProductRegisterRequest(
        String title,
        String content,
        BigInteger price
) {

    public ProductRegisterCommandRequest toRequest(Long memberId) {
        return ProductRegisterCommandRequest.builder()
                .memberId(memberId)
                .title(title)
                .content(content)
                .price(price)
                .build();
    }
}
