package com.jeon.market.auth.infrastructure.service;

import com.jeon.market.auth.application.service.TokenService;
import org.springframework.stereotype.Service;

@Service
public class JwtTokenService implements TokenService {

    @Override
    public String generate(Long id) {
        return null;
    }
}
