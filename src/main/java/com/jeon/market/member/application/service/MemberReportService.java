package com.jeon.market.member.application.service;

import com.jeon.market.member.domain.MemberReport;
import com.jeon.market.member.domain.MemberReportRepository;
import com.jeon.market.member.application.service.request.MemberReportRequest;
import org.springframework.stereotype.Service;

@Service
public class MemberReportService {
    private final MemberReportRepository memberReportRepository;

    public MemberReportService(MemberReportRepository memberReportRepository) {
        this.memberReportRepository = memberReportRepository;
    }

    public MemberReport report(MemberReportRequest request) {
        return memberReportRepository.save(request.toEntity());
    }
}
