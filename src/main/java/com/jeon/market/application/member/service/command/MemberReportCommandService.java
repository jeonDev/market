package com.jeon.market.application.member.service.command;

import com.jeon.market.application.member.domain.Member;
import com.jeon.market.application.member.domain.MemberReport;
import com.jeon.market.application.member.domain.MemberReportRepository;
import com.jeon.market.application.member.domain.MemberRepository;
import com.jeon.market.application.member.service.command.request.MemberReportCommandRequest;
import com.jeon.market.application.member.service.command.response.MemberReportCommandResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class MemberReportCommandService {
    private final MemberReportRepository memberReportRepository;
    private final MemberRepository memberRepository;

    public MemberReportCommandService(MemberReportRepository memberReportRepository,
                                      MemberRepository memberRepository) {
        this.memberReportRepository = memberReportRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public MemberReportCommandResponse report(MemberReportCommandRequest request) {
        // 1. 신고 대상자 조회
        Member reportMember = memberRepository.findById(request.memberId())
                .orElseThrow();

        // 2. 신고자 조회
        Member regMember = memberRepository.findById(request.regMemberId())
                .orElseThrow();

        // 3. 신고 내역 등록
        MemberReport memberReport = MemberReport.of(reportMember.getId(), regMember.getId(), request.report());
        memberReportRepository.save(memberReport);

        // 4. 신고된 내역을 확인 후, 신고 대상자 등급 변경
        Integer reportCount = memberReportRepository.countByMemberId(reportMember.getId());
        regMember.applyGradeByReportCount(reportCount);

        return MemberReportCommandResponse.from(
                memberReport.getId(),
                memberReport.getMemberId(),
                memberReport.getRegMemberId(),
                memberReport.getReport()
        );
    }
}
