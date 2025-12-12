package com.jeon.market.member.endpoint;

import com.jeon.market.member.application.usecase.LoginUseCase;
import com.jeon.market.member.endpoint.payload.LoginPayload;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final LoginUseCase loginUseCase;

    public LoginController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginPayload.Request request) {
        return ResponseEntity.ok(
                loginUseCase.login(request.id(), request.password())
                        .accessToken()
        );
    }
}
