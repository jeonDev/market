package com.jeon.market.application.member.endpoint;

public record MemberCreateRequest(
        String loginId,
        String password,
        String name,
        String phoneNumber
) {
}
