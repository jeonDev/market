package com.jeon.market.application.member.service;

import com.jeon.market.application.member.domain.Member;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record MemberQueryResponse(
        Long id,
        String loginId,
        String name,
        String phoneNumber
) {
    public static MemberQueryResponse from(Member member) {
        return MemberQueryResponse.builder()
                .id(member.getId())
                .loginId(member.getLoginId())
                .name(member.getName())
                .phoneNumber(member.getPhoneNumber())
                .build();
    }
}
