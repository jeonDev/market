package com.jeon.market.application.member.endpoint.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginRequest(
        @NotBlank(message = "아이디를 입력하시오") String id,
        @NotNull(message = "패스워드를 입력하시오") String password
) {

}
