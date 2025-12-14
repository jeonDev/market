package com.jeon.market.product.application.service.request;

import com.jeon.market.product.application.domain.Product;
import com.jeon.market.product.application.domain.type.Category;
import com.jeon.market.product.application.domain.type.ProductStatus;

import java.math.BigInteger;

public record ProductRegisterRequest(
        Long memberId,
        String title,
        String content,
        BigInteger price,
        Category category
) {
    public Product toEntity() {
        return Product.builder()
                .memberId(memberId)
                .category(category)
                .title(title)
                .content(content)
                .price(price)
                .status(ProductStatus.NEW)
                .viewCount(0)
                .build();
    }
}
