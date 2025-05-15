package com.jeon.market.application.product.endpoint;

import com.jeon.market.application.product.service.ProductRegisterCommandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProductController {

    private final ProductRegisterCommandService productRegisterCommandService;

    public ProductController(ProductRegisterCommandService productRegisterCommandService) {
        this.productRegisterCommandService = productRegisterCommandService;
    }

    @PostMapping("/product/register")
    public ResponseEntity<ProductRegisterResponse> register(@RequestBody ProductRegisterRequest request) {
        Long memberId = 1L; // TODO: 로그인 기능 구현 후
        return ResponseEntity.ok(
                ProductRegisterResponse.from(productRegisterCommandService.register(request.toRequest(memberId)))
        );
    }
}
