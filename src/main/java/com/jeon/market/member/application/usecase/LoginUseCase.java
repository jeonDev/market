package com.jeon.market.member.application.usecase;

import com.jeon.market.auth.application.service.TokenService;
import com.jeon.market.auth.infrastructure.service.request.JwtTokenInfo;
import com.jeon.market.common.exception.ServiceException;
import com.jeon.market.member.domain.MemberRepository;
import com.jeon.market.member.application.usecase.response.LoginResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class LoginUseCase {

    private final MemberRepository memberRepository;
    private final TokenService tokenService;

    public LoginUseCase(MemberRepository memberRepository,
                        TokenService tokenService) {
        this.memberRepository = memberRepository;
        this.tokenService = tokenService;
    }

    @Transactional(noRollbackFor = ServiceException.class)
    public LoginResult login(String id,
                             String password) {
        var member = memberRepository.findByLoginId(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 ID"));
        member.login(password);

        var tokenInfo = JwtTokenInfo.builder()
                .id(member.getId())
                .loginId(member.getLoginId())
                .name(member.getName())
                .grade(member.getGrade())
                .build();
        String accessToken = tokenService.generate(tokenInfo);

        return new LoginResult(
                accessToken
        );
    }
}
