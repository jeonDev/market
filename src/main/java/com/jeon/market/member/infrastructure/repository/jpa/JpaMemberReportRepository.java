package com.jeon.market.member.infrastructure.repository.jpa;

import com.jeon.market.member.domain.MemberReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaMemberReportRepository extends JpaRepository<MemberReport, Long> {
    @Query(value = "SELECT COUNT(DISTINCT(mr.regMemberId)) FROM MemberReport mr")
    Integer countByMemberId(Long id);
}
