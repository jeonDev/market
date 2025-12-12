package com.jeon.market.member.application.domain;

public interface MemberReportRepository {

    MemberReport save(MemberReport report);

    Integer countByMemberId(Long id);
}
