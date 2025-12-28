package com.jeon.market.member.application.service;

import com.jeon.market.member.domain.MemberReportRepository;
import com.jeon.market.member.application.service.request.MemberCreateRequest;
import com.jeon.market.member.domain.Member;
import com.jeon.market.member.domain.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberReportRepository memberReportRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberRepository memberRepository,
                         MemberReportRepository memberReportRepository,
                         PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.memberReportRepository = memberReportRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Member create(MemberCreateRequest request) {
        var optionalMember = memberRepository.findByLoginId(request.loginId());
        if (optionalMember.isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 아이디");
        }

        return memberRepository.save(request.toEntity(passwordEncoder));
    }

    public void applyGrade(Member member) {
        Integer reportCount = memberReportRepository.countByMemberId(member.getId());
        member.applyGradeByReportCount(reportCount);
    }
}
