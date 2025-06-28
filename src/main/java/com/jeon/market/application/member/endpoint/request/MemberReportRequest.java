package com.jeon.market.application.member.endpoint.request;

import com.jeon.market.application.member.domain.type.Report;
import com.jeon.market.application.member.service.command.request.MemberReportCommandRequest;

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
