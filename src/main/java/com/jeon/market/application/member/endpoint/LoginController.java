package com.jeon.market.application.member.endpoint;

import com.jeon.market.application.member.endpoint.request.LoginRequest;
import com.jeon.market.application.member.service.command.LoginCommandService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final LoginCommandService loginCommandService;

    public LoginController(LoginCommandService loginCommandService) {
        this.loginCommandService = loginCommandService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest request) {
        return ResponseEntity.ok(
                loginCommandService.login(request.id(), request.password())
                        .accessToken()
        );
    }
}
