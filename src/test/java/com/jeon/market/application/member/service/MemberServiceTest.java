package com.jeon.market.application.member.service;

import com.jeon.market.application.member.domain.Member;
import com.jeon.market.application.member.domain.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MemberServiceTest {
    private MemberRepository memberRepository;
    private CreateMemberCommandService memberService;

    @BeforeEach
    void setUp() {
        memberRepository = mock(MemberRepository.class);
        memberService = new CreateMemberCommandService(memberRepository);
    }

    @DisplayName("고객정보 생성 성공")
    @Test
    void 고객정보생성_성공() {
        String loginId = "loginId";
        String password = "password";
        String name = "name";
        String phoneNumber = "01000001111";

        Member member = Member.createMember(loginId, password, name, phoneNumber);
        when(memberRepository.createMember(any(Member.class))).thenReturn(member);

        CreateMemberCommandResponse response = memberService.createMember(loginId, password, name, phoneNumber);

        assertThat(response.loginId()).isEqualTo(loginId);
        assertThat(response.name()).isEqualTo(name);
        assertThat(response.phoneNumber()).isEqualTo(phoneNumber);
    }
}