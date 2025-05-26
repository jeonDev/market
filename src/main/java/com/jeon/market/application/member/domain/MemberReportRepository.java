package com.jeon.market.application.member.domain;

public interface MemberReportRepository {

    MemberReport save(MemberReport report);

    Integer countByMemberId(Long id);
}
