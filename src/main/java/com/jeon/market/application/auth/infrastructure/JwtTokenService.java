package com.jeon.market.application.auth.infrastructure;

import com.jeon.market.application.auth.service.TokenService;
import org.springframework.stereotype.Service;

@Service
public class JwtTokenService implements TokenService {

    @Override
    public String generate(Long id) {
        return null;
    }
}
