package com.jeon.market.product.application.usecase.response;

import java.math.BigInteger;

public record ProductRegisterResult(
        Long id,
        Long memberId,
        String title,
        String content,
        BigInteger price
) {
}
