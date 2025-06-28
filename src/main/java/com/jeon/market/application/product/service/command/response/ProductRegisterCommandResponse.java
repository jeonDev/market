package com.jeon.market.application.product.service.command.response;

import com.jeon.market.application.product.domain.Product;
import lombok.AccessLevel;
import lombok.Builder;

import java.math.BigInteger;

@Builder(access = AccessLevel.PRIVATE)
public record ProductRegisterCommandResponse(
        Long id,
        String title,
        String content,
        BigInteger price
) {

    public static ProductRegisterCommandResponse from(Product product) {
        return ProductRegisterCommandResponse.builder()
                .id(product.getId())
                .title(product.getTitle())
                .content(product.getContent())
                .price(product.getPrice())
                .build();
    }
}
