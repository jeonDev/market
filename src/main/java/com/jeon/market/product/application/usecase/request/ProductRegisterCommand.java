package com.jeon.market.product.application.usecase.request;

import com.jeon.market.product.application.service.request.ProductRegisterRequest;

import java.math.BigInteger;

public record ProductRegisterCommand(
        Long memberId,
        String title,
        String content,
        BigInteger price
) {
    public ProductRegisterRequest toRequest() {
        return new ProductRegisterRequest(
                this.memberId,
                this.title,
                this.content,
                this.price
        );
    }
}
