package com.jeon.market.product.application.usecase.request;

import com.jeon.market.product.domain.type.Category;
import com.jeon.market.product.application.service.request.ProductRegisterRequest;

import java.math.BigInteger;

public record ProductRegisterCommand(
        Long memberId,
        String title,
        String content,
        BigInteger price,
        Category category
) {
    public ProductRegisterRequest toRequest() {
        return new ProductRegisterRequest(
                this.memberId,
                this.title,
                this.content,
                this.price,
                this.category
        );
    }
}
