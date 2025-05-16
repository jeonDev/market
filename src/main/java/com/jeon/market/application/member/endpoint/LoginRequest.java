package com.jeon.market.application.member.endpoint;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String id;
    private String password;
}
