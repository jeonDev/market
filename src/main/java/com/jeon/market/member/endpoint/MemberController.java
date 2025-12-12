package com.jeon.market.member.endpoint;

import com.jeon.market.member.application.usecase.MemberCreateUseCase;
import com.jeon.market.member.endpoint.payload.MemberCreatePayload;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MemberController {

    private final MemberCreateUseCase memberCreateUseCase;

    public MemberController(MemberCreateUseCase memberCreateUseCase) {
        this.memberCreateUseCase = memberCreateUseCase;
    }

    @PostMapping("/member/create")
    public MemberCreatePayload.Response create(@RequestBody @Valid MemberCreatePayload.Request request) {
        var result = memberCreateUseCase.execute(request.toRequest());
        return new MemberCreatePayload.Response(
                result.id()
        );
    }

}
