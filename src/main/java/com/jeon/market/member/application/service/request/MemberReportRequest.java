package com.jeon.market.member.application.service.request;

import com.jeon.market.member.application.domain.MemberReport;
import com.jeon.market.member.application.domain.type.Report;

public record MemberReportRequest(
        Long memberId,
        Long regMemberId,
        Report report
) {
    public MemberReport toEntity() {
        return MemberReport.builder()
                .report(report)
                .memberId(memberId)
                .regMemberId(regMemberId)
                .build();
    }
}
