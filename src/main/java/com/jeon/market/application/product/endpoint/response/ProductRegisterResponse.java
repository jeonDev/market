package com.jeon.market.application.product.endpoint.response;

import com.jeon.market.application.product.service.command.response.ProductRegisterCommandResponse;
import lombok.AccessLevel;
import lombok.Builder;

import java.math.BigInteger;

@Builder(access = AccessLevel.PRIVATE)
public record ProductRegisterResponse(
        Long id,
        String title,
        String content,
        BigInteger price
) {

    public static ProductRegisterResponse from(ProductRegisterCommandResponse response) {
        return ProductRegisterResponse.builder()
                .id(response.id())
                .title(response.title())
                .content(response.content())
                .price(response.price())
                .build();
    }
}
