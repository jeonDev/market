package com.jeon.market.application.member.service;

import com.jeon.market.application.auth.service.TokenService;
import com.jeon.market.application.member.domain.Member;
import com.jeon.market.application.member.domain.MemberRepository;
import com.jeon.market.application.member.service.response.LoginCommandResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginCommandService {

    private final MemberRepository memberRepository;
    private final TokenService tokenService;

    public LoginCommandService(MemberRepository memberRepository,
                               TokenService tokenService) {
        this.memberRepository = memberRepository;
        this.tokenService = tokenService;
    }

    @Transactional(noRollbackFor = IllegalArgumentException.class)
    public LoginCommandResponse login(String id, String password) {
        Member member = memberRepository.findByLoginId(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 ID"));
        member.login(password);

        String accessToken = tokenService.generate(member.getId());

        return LoginCommandResponse.from(accessToken);
    }
}
