package com.jeon.market.member.endpoint.payload;

import com.jeon.market.member.domain.type.Report;
import com.jeon.market.member.application.usecase.request.MemberReportCommand;
import io.swagger.v3.oas.annotations.media.Schema;

public record MemberReportPayload() {
    @Schema(name = "MemberReportRequest")
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

    @Schema(name = "MemberReportResponse")
    public record Response(
            Long id
    ) {

    }
}
