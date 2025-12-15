package com.jeon.market.member.infrastructure.repository;

import com.jeon.market.member.domain.Member;
import com.jeon.market.member.domain.MemberRepository;
import com.jeon.market.member.infrastructure.repository.jpa.JpaMemberRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

    private final JpaMemberRepository jpaMemberRepository;

    public MemberRepositoryImpl(JpaMemberRepository jpaMemberRepository) {
        this.jpaMemberRepository = jpaMemberRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Member> findById(Long id) {
        return jpaMemberRepository.findById(id);
    }

    @Override
    public Optional<Member> findByLoginId(String loginId) {
        return jpaMemberRepository.findByLoginId(loginId);
    }

    @Override
    @Transactional
    public Member save(Member member) {

        return jpaMemberRepository.save(member);
    }
}
