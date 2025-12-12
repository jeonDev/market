package com.jeon.market.member.application.usecase;

import com.jeon.market.member.application.domain.Member;
import com.jeon.market.member.application.domain.MemberReport;
import com.jeon.market.member.application.domain.MemberReportRepository;
import com.jeon.market.member.application.domain.MemberRepository;
import com.jeon.market.member.application.service.MemberReportService;
import com.jeon.market.member.application.service.MemberService;
import com.jeon.market.member.application.service.request.MemberReportRequest;
import com.jeon.market.member.application.usecase.request.MemberReportCommand;
import com.jeon.market.member.application.usecase.response.MemberReportResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class MemberReportUseCase {
    private final MemberReportService memberReportService;
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    public MemberReportUseCase(MemberReportService memberReportService,
                               MemberService memberService,
                               MemberRepository memberRepository) {
        this.memberReportService = memberReportService;
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public MemberReportResult execute(MemberReportCommand command) {
        // 1. 신고 대상자 조회
        Member reportMember = memberRepository.findById(command.memberId())
                .orElseThrow();

        // 2. 신고자 조회
        Member regMember = memberRepository.findById(command.regMemberId())
                .orElseThrow();

        // 3. 신고 내역 등록
        var request = new MemberReportRequest(regMember.getId(), reportMember.getId(), command.report());
        var reportEntity = memberReportService.report(request);

        memberService.applyGrade(reportMember);

        return new MemberReportResult(
                reportEntity.getId(),
                reportEntity.getMemberId(),
                reportEntity.getRegMemberId(),
                reportEntity.getReport()
        );
    }
}
