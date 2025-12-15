package com.jeon.market.product.application.usecase;

import com.jeon.market.member.domain.Member;
import com.jeon.market.member.domain.MemberRepository;
import com.jeon.market.product.domain.Product;
import com.jeon.market.product.domain.ProductRepository;
import com.jeon.market.product.application.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ProductCompleteUseCase {

    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final ProductService productService;

    public ProductCompleteUseCase(MemberRepository memberRepository,
                                  ProductRepository productRepository,
                                  ProductService productService) {
        this.memberRepository = memberRepository;
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @Transactional
    public void execute(Long productId, Long memberId) {
        // 1. 유효한 고객인지 체크.
        Member member = memberRepository.findById(memberId)
                .orElseThrow();
        member.activeMemberCheck();

        // 2. 상품 조회 및 존재 여부 체크
        Product product = productRepository.findById(productId)
                .orElseThrow();

        productService.transactionComplete(product);
    }
}
