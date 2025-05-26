package com.jeon.market.application.member.infrastructure;

import com.jeon.market.application.member.domain.MemberReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaMemberReportRepository extends JpaRepository<MemberReport, Long> {
    @Query(value = "SELECT COUNT(DISTINCT(mr.regMemberId)) FROM MemberReport mr")
    Integer countByMemberId(Long id);
}
