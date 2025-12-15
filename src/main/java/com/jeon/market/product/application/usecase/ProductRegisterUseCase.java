package com.jeon.market.product.application.usecase;

import com.jeon.market.member.domain.Member;
import com.jeon.market.member.domain.MemberRepository;
import com.jeon.market.product.application.service.ProductService;
import com.jeon.market.product.application.usecase.request.ProductRegisterCommand;
import com.jeon.market.product.application.usecase.response.ProductRegisterResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ProductRegisterUseCase {
    private final ProductService productService;
    private final MemberRepository memberRepository;

    public ProductRegisterUseCase(ProductService productService,
                                  MemberRepository memberRepository) {
        this.productService = productService;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public ProductRegisterResult execute(ProductRegisterCommand command) {
        // 1. 유효한 고객인지 체크.
        Member member = memberRepository.findById(command.memberId())
                .orElseThrow();
        member.activeMemberCheck();

        // 2. 상품 정보 등록
        var productEntity = productService.register(command.toRequest());

        return new ProductRegisterResult(
                productEntity.getId(),
                productEntity.getMemberId(),
                productEntity.getTitle(),
                productEntity.getContent(),
                productEntity.getPrice()
        );
    }

}
