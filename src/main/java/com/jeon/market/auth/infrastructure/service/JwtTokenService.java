package com.jeon.market.auth.infrastructure.service;

import com.jeon.market.auth.application.service.TokenService;
import com.jeon.market.auth.application.service.request.TokenInfo;
import com.jeon.market.auth.infrastructure.service.request.JwtTokenInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtTokenService implements TokenService {

    private final String secretKey;
    private final Long expireTime = 60L * 60L * 60L;

    public JwtTokenService(@Value("${security.secret-key}") String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public String generate(TokenInfo tokenInfo) {
        assert tokenInfo != null;
        assert tokenInfo.getId() != null;
        JwtTokenInfo jwtTokenInfo = (JwtTokenInfo) tokenInfo;

        Claims claims = Jwts.claims().setSubject(String.valueOf(jwtTokenInfo.getId()));
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + expireTime);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}
