package com.jeon.market.application.member.service.command.request;

import com.jeon.market.application.member.domain.type.Report;
import lombok.Builder;

@Builder
public record MemberReportCommandRequest(
        Long memberId,
        Long regMemberId,
        Report report
) {
}
