package com.jeon.market.auth.infrastructure.service.request;

import com.jeon.market.auth.application.service.request.TokenInfo;
import com.jeon.market.member.domain.type.Grade;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class JwtTokenInfo implements TokenInfo {

    private final Long id;
    private final String loginId;
    private final String name;
    private final Grade grade;
}
