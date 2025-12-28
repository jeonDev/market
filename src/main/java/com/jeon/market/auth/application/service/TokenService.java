package com.jeon.market.auth.application.service;

import com.jeon.market.auth.application.service.request.TokenInfo;

public interface TokenService {

    String generate(TokenInfo tokenInfo);
}
