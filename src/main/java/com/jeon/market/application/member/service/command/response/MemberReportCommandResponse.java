package com.jeon.market.application.member.service.command.response;

import com.jeon.market.application.member.domain.type.Report;

public record MemberReportCommandResponse(
        Long id,
        Long memberId,
        Long regMemberId,
        Report report
) {
    public static MemberReportCommandResponse from(Long id, Long memberId, Long regMemberId, Report report) {
        return new MemberReportCommandResponse(id, memberId, regMemberId, report);
    }
}
