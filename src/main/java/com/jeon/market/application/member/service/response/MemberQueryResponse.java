package com.jeon.market.application.member.service.response;

import com.jeon.market.application.member.domain.type.Grade;
import com.jeon.market.application.member.domain.Member;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record MemberQueryResponse(
        Long id,
        String loginId,
        String name,
        String phoneNumber,
        Grade grade
) {
    public static MemberQueryResponse from(Member member) {
        return MemberQueryResponse.builder()
                .id(member.getId())
                .loginId(member.getLoginId())
                .name(member.getName())
                .phoneNumber(member.getPhoneNumber())
                .grade(member.getGrade())
                .build();
    }

    // TODO: 어느 위치에서 검증을 해야하나
    public void activeMemberCheck() {
        // 회원 등급 확인
        if (this.grade == Grade.BLACK_LIST) {
            throw new IllegalStateException("블랙리스트 회원");
        }
    }
}
