package com.jeon.market.application.member.endpoint;

import com.jeon.market.application.member.domain.type.Report;
import com.jeon.market.application.member.service.MemberReportCommandRequest;

public record MemberReportRequest(
        Long memberId,
        String report
) {
    public MemberReportCommandRequest toRequest(Long regMemberId) {
        return MemberReportCommandRequest.builder()
                .memberId(memberId)
                .regMemberId(regMemberId)
                .report(Report.valueOf(report))
                .build();
    }
}
