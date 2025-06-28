package com.jeon.market.application.member.endpoint.request;

import com.jeon.market.application.member.service.command.request.CreateMemberCommandRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MemberCreateRequest(
        @NotBlank(message = "아이디를 입력하시오") String loginId,
        @NotBlank(message = "패스워드를 입력하시오") String password,
        @NotBlank(message = "이름을 입력하시오") String name,
        @NotNull(message = "핸드폰 번호를 입력하시오") String phoneNumber
) {
    public CreateMemberCommandRequest toRequest() {
        this.loginIdValid();
        this.passwordValid();
        this.nameValid();
        this.phoneNumberValid();

        return CreateMemberCommandRequest.builder()
                .loginId(loginId)
                .password(password)
                .name(name)
                .phoneNumber(phoneNumber)
                .build();
    }

    private void loginIdValid() {
        if (loginId == null || loginId.isEmpty()) throw new IllegalArgumentException();
        if (loginId.length() < 6 || loginId.length() > 20) throw new IllegalArgumentException();
    }

    private void passwordValid() {
        if (password == null || password.isEmpty()) throw new IllegalArgumentException();
        if (password.length() < 6 || password.length() > 20) throw new IllegalArgumentException();
    }

    private void nameValid() {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException();
    }

    private void phoneNumberValid() {
        if (phoneNumber == null || phoneNumber.isEmpty()) throw new IllegalArgumentException();
    }
}
