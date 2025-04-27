package com.jeon.market.application.member.infrastructure;

import com.jeon.market.application.member.domain.Member;
import com.jeon.market.application.member.domain.MemberRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

    private final JpaMemberRepository jpaMemberRepository;

    public MemberRepositoryImpl(JpaMemberRepository jpaMemberRepository) {
        this.jpaMemberRepository = jpaMemberRepository;
    }

    @Override
    @Transactional
    public Member createMember(Member member) {
        jpaMemberRepository.findByLoginId(member.getLoginId())
                .ifPresent(item -> {
                    throw new IllegalArgumentException("이미 존재하는 아이디");
                });
        return jpaMemberRepository.save(member);
    }
}
