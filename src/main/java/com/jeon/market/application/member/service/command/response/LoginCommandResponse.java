package com.jeon.market.application.member.service.command.response;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record LoginCommandResponse(
        String accessToken
) {
    public static LoginCommandResponse from(String accessToken) {
        return LoginCommandResponse.builder()
                .accessToken(accessToken)
                .build();
    }
}
