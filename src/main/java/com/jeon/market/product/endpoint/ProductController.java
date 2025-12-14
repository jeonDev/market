package com.jeon.market.product.endpoint;

import com.jeon.market.auth.application.service.SessionService;
import com.jeon.market.product.application.usecase.ProductCompleteUseCase;
import com.jeon.market.product.application.usecase.ProductRegisterUseCase;
import com.jeon.market.product.endpoint.payload.ProductRegisterPayload;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Tag(name = "상품", description = "상품 관련 API")
public class ProductController {

    private final SessionService sessionService;
    private final ProductRegisterUseCase productRegisterUseCase;
    private final ProductCompleteUseCase productCompleteUseCase;

    public ProductController(SessionService sessionService,
                             ProductRegisterUseCase productRegisterUseCase,
                             ProductCompleteUseCase productCompleteUseCase) {
        this.sessionService = sessionService;
        this.productRegisterUseCase = productRegisterUseCase;
        this.productCompleteUseCase = productCompleteUseCase;
    }

    @Operation(summary = "상품 등록")
    @PostMapping("/product/register")
    public ProductRegisterPayload.Response register(@RequestBody @Valid ProductRegisterPayload.Request request) {
        Long memberId = sessionService.getMemberId();
        var execute = productRegisterUseCase.execute(request.toRequest(memberId));
        return new ProductRegisterPayload.Response(
                execute.id(),
                execute.title(),
                execute.content(),
                execute.price()
        );
    }

    @Operation(summary = "상품 판매 완료 처리")
    @PatchMapping("/product/complete/{productId}")
    public void complete(@PathVariable("productId") Long productId) {
        Long memberId = sessionService.getMemberId();
        productCompleteUseCase.execute(productId, memberId);
    }
}
