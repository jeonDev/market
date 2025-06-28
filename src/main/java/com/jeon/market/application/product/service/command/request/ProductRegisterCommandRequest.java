package com.jeon.market.application.product.service.command.request;

import lombok.Builder;

import java.math.BigInteger;

@Builder
public record ProductRegisterCommandRequest(
        Long memberId,
        String title,
        String content,
        BigInteger price
) {
}
