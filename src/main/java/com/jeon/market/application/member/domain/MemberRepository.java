package com.jeon.market.application.member.domain;

import java.util.Optional;

public interface MemberRepository {

    Optional<Member> findById(Long id);
    Member createMember(Member member);
}
