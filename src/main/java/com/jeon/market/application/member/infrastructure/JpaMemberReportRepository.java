package com.jeon.market.application.member.infrastructure;

import com.jeon.market.application.member.domain.MemberReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMemberReportRepository extends JpaRepository<MemberReport, Long> {
    Integer countByMemberId(Long id);
}
