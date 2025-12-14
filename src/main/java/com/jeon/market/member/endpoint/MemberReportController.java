package com.jeon.market.member.endpoint;

import com.jeon.market.auth.application.service.SessionService;
import com.jeon.market.member.application.usecase.MemberReportUseCase;
import com.jeon.market.member.endpoint.payload.MemberReportPayload;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Tag(name = "사용자 관리", description = "사용자 관련 API")
public class MemberReportController {

    private final MemberReportUseCase memberReportUseCase;
    private final SessionService sessionService;

    public MemberReportController(MemberReportUseCase memberReportUseCase,
                                  SessionService sessionService) {
        this.memberReportUseCase = memberReportUseCase;
        this.sessionService = sessionService;
    }

    @Operation(summary = "사용자 신고", description = "사용자를 신고합니다.")
    @PostMapping("/member/report")
    public MemberReportPayload.Response report(@RequestBody MemberReportPayload.Request request) {
        Long memberId = sessionService.getMemberId();
        var result = memberReportUseCase.execute(request.toRequest(memberId));
        return new MemberReportPayload.Response(result.id());
    }
}
