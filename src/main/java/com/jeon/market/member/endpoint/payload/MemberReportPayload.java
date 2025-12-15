package com.jeon.market.member.endpoint.payload;

import com.jeon.market.member.domain.type.Report;
import com.jeon.market.member.application.usecase.request.MemberReportCommand;

public record MemberReportPayload() {
    public record Request(
            Long memberId,
            String report
    ) {
        public MemberReportCommand toRequest(Long regMemberId) {
            return MemberReportCommand.builder()
                    .memberId(memberId)
                    .regMemberId(regMemberId)
                    .report(Report.valueOf(report))
                    .build();
        }
    }

    public record Response(
            Long id
    ) {

    }
}
