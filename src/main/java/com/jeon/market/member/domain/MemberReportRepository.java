package com.jeon.market.member.domain;

public interface MemberReportRepository {

    MemberReport save(MemberReport report);

    Integer countByMemberId(Long id);
}
