package com.jeon.market.member.endpoint.payload;

import com.jeon.market.member.application.usecase.request.CreateMemberCommand;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MemberCreatePayload() {

    public record Request(
            @Schema(description = "ID", example = "test") @NotBlank String loginId,
            @Schema(description = "패스워드", example = "1234") @NotBlank String password,
            @Schema(description = "이름", example = "사용자") @NotBlank String name,
            @Schema(description = "전화번호", example = "01011112222") @NotNull String phoneNumber
    ) {
        public CreateMemberCommand toRequest() {
            this.loginIdValid();
            this.passwordValid();
            this.nameValid();
            this.phoneNumberValid();

            return CreateMemberCommand.builder()
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

    public record Response(
            @Schema(description = "seq", example = "1") Long id
    ) {

    }
}
