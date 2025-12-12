package com.jeon.market.member.application.domain;

import java.util.Optional;

public interface MemberRepository {

    Optional<Member> findById(Long id);
    Optional<Member> findByLoginId(String loginId);

    Member save(Member member);
}
