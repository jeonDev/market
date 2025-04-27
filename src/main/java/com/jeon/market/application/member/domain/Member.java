package com.jeon.market.application.member.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "MEMBER")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String loginId;
    private String password;
    private String name;
    private String phoneNumber;

    protected Member() {
    }

    private Member(String loginId, String password, String name, String phoneNumber) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
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

}
