package com.jeon.market.member.endpoint;

import com.jeon.market.member.application.usecase.LoginUseCase;
import com.jeon.market.member.endpoint.payload.LoginPayload;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "사용자 관리", description = "사용자 관련 API")
public class LoginController {
    private final LoginUseCase loginUseCase;

    public LoginController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @Operation(summary = "로그인", description = "로그인합니다")
    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginPayload.Request request) {
        return ResponseEntity.ok(
                loginUseCase.login(request.id(), request.password())
                        .accessToken()
        );
    }
}
