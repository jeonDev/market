package com.jeon.market.application.auth.infrastructure;

import com.jeon.market.application.auth.service.SessionService;
import org.springframework.stereotype.Service;

@Service
public class JwtSessionStorageService implements SessionService {

    @Override
    public Long getMemberId() {
        // TODO:
        return 1L;
    }
}
