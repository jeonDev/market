package com.jeon.market.application.member.service;

import com.jeon.market.application.member.domain.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberQueryService {

    private final MemberRepository memberRepository;

    public MemberQueryService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional(readOnly = true)
    public MemberQueryResponse findById(Long id) {
        return MemberQueryResponse.from(
                memberRepository.findById(id).orElseThrow()
        );
    }
}
