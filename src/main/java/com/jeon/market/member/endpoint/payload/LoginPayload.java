package com.jeon.market.member.endpoint.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginPayload() {

    @Schema(name = "LoginRequest")
    public record Request(
            @Schema(description = "아이디", example = "test") @NotBlank String loginId,
            @Schema(description = "패스워드", example = "1234") @NotNull String password
    ) {}
}
