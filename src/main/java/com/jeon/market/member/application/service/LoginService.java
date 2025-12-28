package com.jeon.market.member.application.service;

import com.jeon.market.auth.application.service.request.TokenInfo;
import com.jeon.market.auth.infrastructure.service.request.JwtTokenInfo;
import com.jeon.market.common.exception.ErrorType;
import com.jeon.market.common.exception.ServiceException;
import com.jeon.market.member.domain.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginService(MemberRepository memberRepository,
                        PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(noRollbackFor = ServiceException.class)
    public TokenInfo login(String loginId, String password) {
        var member = memberRepository.findByLoginId(loginId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 ID"));

        member.loginCheck();

        if (!passwordEncoder.matches(password, member.getPassword())) {
            member.loginFailed();
            memberRepository.save(member);
            throw new ServiceException(ErrorType.LOGIN_PASSWORD_UNMATCHED);
        }

        return JwtTokenInfo.builder()
                .id(member.getId())
                .loginId(member.getLoginId())
                .name(member.getName())
                .grade(member.getGrade())
                .build();
    }

}
