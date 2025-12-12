package com.jeon.market.member.endpoint;

import com.jeon.market.auth.application.service.SessionService;
import com.jeon.market.member.application.usecase.MemberReportUseCase;
import com.jeon.market.member.endpoint.payload.MemberReportPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MemberReportController {

    private final MemberReportUseCase memberReportUseCase;
    private final SessionService sessionService;

    public MemberReportController(MemberReportUseCase memberReportUseCase,
                                  SessionService sessionService) {
        this.memberReportUseCase = memberReportUseCase;
        this.sessionService = sessionService;
    }

    @PostMapping("/member/report")
    public MemberReportPayload.Response report(@RequestBody MemberReportPayload.Request request) {
        Long memberId = sessionService.getMemberId();
        var result = memberReportUseCase.execute(request.toRequest(memberId));
        return new MemberReportPayload.Response(result.id());
    }
}
