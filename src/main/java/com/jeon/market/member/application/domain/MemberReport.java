package com.jeon.market.member.application.domain;

import com.jeon.market.member.application.domain.type.Report;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
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

}
