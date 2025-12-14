package com.jeon.market.member.endpoint;

import com.jeon.market.member.application.usecase.MemberCreateUseCase;
import com.jeon.market.member.endpoint.payload.MemberCreatePayload;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Tag(name = "사용자 관리", description = "사용자 관련 API")
public class MemberController {

    private final MemberCreateUseCase memberCreateUseCase;

    public MemberController(MemberCreateUseCase memberCreateUseCase) {
        this.memberCreateUseCase = memberCreateUseCase;
    }

    @Operation(summary = "사용자 등록", description = "사용자 정보를 등록합니다. (회원가입)")
    @PostMapping("/member/create")
    public MemberCreatePayload.Response create(@RequestBody @Valid MemberCreatePayload.Request request) {
        var result = memberCreateUseCase.execute(request.toRequest());
        return new MemberCreatePayload.Response(
                result.id()
        );
    }

}
