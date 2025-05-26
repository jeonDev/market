package com.jeon.market.application.member.domain;

import com.jeon.market.application.member.domain.type.Grade;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "MEMBER")
@Access(AccessType.FIELD)
public class Member {

    private final Integer MAX_WRONG_PASSWORD_COUNT = 5;
    private final Integer BLACKLIST_REPORT_COUNT = 10;

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    @Getter
    @Column(name = "LOGIN_ID", nullable = false, length = 100)
    private String loginId;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Getter
    @Column(name = "NAME", nullable = false, length = 30)
    private String name;

    @Getter
    @Column(name = "PHONE_NUMBER", length = 11)
    private String phoneNumber;

    @Column(name = "WRONG_PASSWORD_COUNT")
    private Integer wrongPasswordCount;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(name = "GRADE")
    private Grade grade;

    protected Member() {
    }

    private Member(String loginId, String password, String name, String phoneNumber) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.wrongPasswordCount = 0;
        this.grade = Grade.BASIC;
    }

    public static Member createMember(String loginId,
                                      String password,
                                      String name,
                                      String phoneNumber) {
        validCreateMember(loginId, password, name, phoneNumber);
        return new Member(loginId, password, name, phoneNumber);
    }

    private static void validCreateMember(String loginId, String password, String name, String phoneNumber) {
        if (loginId == null || loginId.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (phoneNumber == null || phoneNumber.isEmpty() || phoneNumber.length() > 11) {
            throw new IllegalArgumentException();
        }
    }

    public void login(String password) {
        this.validPassword(password);
        this.validWrongPasswordCount();
        if (!this.password.equals(password)) {
            this.wrongPasswordCount++;
            throw new IllegalArgumentException("패스워드 불일치");
        }
    }

    private void validWrongPasswordCount() {
        if (this.wrongPasswordCount > MAX_WRONG_PASSWORD_COUNT) {
            this.wrongPasswordCount++;
            throw new IllegalArgumentException("패스워드 틀린횟수 초과");
        }
    }

    private void validPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("패스워드 미 입력");
        }
    }

    public void applyGradeByReportCount(Integer reportCount) {
        if (reportCount >= BLACKLIST_REPORT_COUNT) {
            this.grade = Grade.BLACK_LIST;
        }
    }
}
