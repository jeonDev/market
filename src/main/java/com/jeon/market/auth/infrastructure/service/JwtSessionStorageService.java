package com.jeon.market.auth.infrastructure.service;

import com.jeon.market.auth.application.service.SessionService;
import org.springframework.stereotype.Service;

@Service
public class JwtSessionStorageService implements SessionService {

    @Override
    public Long getMemberId() {
        // TODO:
        return 1L;
    }
}
