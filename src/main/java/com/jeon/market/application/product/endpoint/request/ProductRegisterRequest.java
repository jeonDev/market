package com.jeon.market.application.product.endpoint.request;

import com.jeon.market.application.product.service.request.ProductRegisterCommandRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigInteger;

public record ProductRegisterRequest(
        @NotBlank(message = "제목을 입력하시오") String title,
        @NotNull(message = "내용을 입력하시오") String content,
        @NotNull(message = "금액을 입력하시오") @PositiveOrZero(message = "0원 이상으로 입력하시오") BigInteger price
) {

    public ProductRegisterCommandRequest toRequest(Long memberId) {
        if (memberId == null) throw new IllegalArgumentException();
        return ProductRegisterCommandRequest.builder()
                .memberId(memberId)
                .title(title)
                .content(content)
                .price(price)
                .build();
    }
}
