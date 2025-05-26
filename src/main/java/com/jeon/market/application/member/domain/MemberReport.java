package com.jeon.market.application.member.domain;

import com.jeon.market.application.member.domain.type.Report;
import jakarta.persistence.*;
import lombok.Getter;


@Getter
@Entity
@Table(name = "MEMBER_REPORT")
@Access(AccessType.FIELD)
public class MemberReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_REPORT_ID")
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Column(name = "REG_MEMBER_ID")
    private Long regMemberId;

    @Enumerated(EnumType.STRING)
    @Column(name = "REPORT")
    private Report report;


    protected MemberReport() {
    }

    private MemberReport(Long memberId, Long regMemberId, Report report) {
        this.memberId = memberId;
        this.regMemberId = regMemberId;
        this.report = report;
    }

    public static MemberReport of(Long memberId, Long regMemberId, Report report) {
        return new MemberReport(memberId, regMemberId, report);
    }

}
