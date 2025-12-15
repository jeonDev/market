package com.jeon.market.member.application.usecase.request;

import com.jeon.market.member.domain.type.Report;
import lombok.Builder;

@Builder
public record MemberReportCommand(
        Long memberId,
        Long regMemberId,
        Report report
) {
}
