package com.jeon.market.member.application.usecase;

import com.jeon.market.auth.application.service.TokenService;
import com.jeon.market.auth.application.service.request.TokenInfo;
import com.jeon.market.member.application.service.LoginService;
import com.jeon.market.member.application.usecase.response.LoginResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginUseCase {

    private final LoginService loginService;
    private final TokenService tokenService;

    public LoginUseCase(LoginService loginService,
                        TokenService tokenService) {
        this.loginService = loginService;
        this.tokenService = tokenService;
    }

    public LoginResult login(String loginId,
                             String password
    ) {
        TokenInfo tokenInfo = loginService.login(loginId, password);

        String accessToken = tokenService.generate(tokenInfo);

        return new LoginResult(
                accessToken
        );
    }
}
