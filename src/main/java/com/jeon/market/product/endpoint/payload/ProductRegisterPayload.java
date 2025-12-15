package com.jeon.market.product.endpoint.payload;

import com.jeon.market.product.domain.type.Category;
import com.jeon.market.product.application.usecase.request.ProductRegisterCommand;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigInteger;

public record ProductRegisterPayload() {

    public record Request(
            @Schema(description = "제목", example = "옷을 판매합니다.") @NotBlank String title,
            @Schema(description = "내용", example = "남성용 바지 사이즈 XX") @NotNull String content,
            @Schema(description = "가격", example = "10000") @NotNull @PositiveOrZero BigInteger price,
            @Schema(description = "카테고리", example = "ETC") @NotNull Category category
    ) {

        public ProductRegisterCommand toRequest(Long memberId) {
            return new ProductRegisterCommand(
                    memberId,
                    this.title,
                    this.content,
                    this.price,
                    this.category
            );
        }
    }

    public record Response(
            @Schema(description = "seq", example = "1") Long id,
            @Schema(description = "제목", example = "옷을 판매합니다.") String title,
            @Schema(description = "내용", example = "남성용 바지 사이즈 XX") String content,
            @Schema(description = "가격", example = "10000") BigInteger price
    ) {

    }
}
