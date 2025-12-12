package com.jeon.market.member.infrastructure;

import com.jeon.market.member.application.domain.MemberReport;
import com.jeon.market.member.application.domain.MemberReportRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MemberReportRepositoryImpl implements MemberReportRepository {

    private final JpaMemberReportRepository jpaMemberReportRepository;

    public MemberReportRepositoryImpl(JpaMemberReportRepository jpaMemberReportRepository) {
        this.jpaMemberReportRepository = jpaMemberReportRepository;
    }

    @Override
    @Transactional
    public MemberReport save(MemberReport memberReport) {
        return jpaMemberReportRepository.save(memberReport);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer countByMemberId(Long id) {
        return jpaMemberReportRepository.countByMemberId(id);
    }
}
