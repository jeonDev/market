package com.jeon.market.application.member.service;

import com.jeon.market.application.member.domain.Member;
import com.jeon.market.application.member.domain.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginCommandService {

    private final MemberRepository memberRepository;

    public LoginCommandService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional()
    public LoginCommandResponse login(String id, String password) {
        Member member = memberRepository.findByLoginId(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 ID"));
        member.login(password);

        String accessToken = ""; // TODO:

        return LoginCommandResponse.from(accessToken);
    }
}
