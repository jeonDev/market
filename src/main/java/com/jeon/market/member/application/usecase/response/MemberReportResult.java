package com.jeon.market.member.application.usecase.response;

import com.jeon.market.member.domain.type.Report;

public record MemberReportResult(
        Long id,
        Long memberId,
        Long regMemberId,
        Report report
) {
}
