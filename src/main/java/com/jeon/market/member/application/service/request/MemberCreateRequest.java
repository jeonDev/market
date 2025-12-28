package com.jeon.market.member.application.service.request;

import com.jeon.market.member.domain.Member;
import org.springframework.security.crypto.password.PasswordEncoder;

public record MemberCreateRequest(
        String loginId,
        String password,
        String name,
        String phoneNumber
) {
    public Member toEntity(PasswordEncoder passwordEncoder) {
        return Member.createMember(loginId, passwordEncoder.encode(password), name, phoneNumber);
    }
}
