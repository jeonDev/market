package com.jeon.market.member.domain;

import java.util.Optional;

public interface MemberRepository {

    Optional<Member> findById(Long id);
    Optional<Member> findByLoginId(String loginId);

    Member save(Member member);
}
