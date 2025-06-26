package com.jeon.market.application.product.service;

import com.jeon.market.application.member.domain.Member;
import com.jeon.market.application.member.domain.MemberRepository;
import com.jeon.market.application.product.domain.Product;
import com.jeon.market.application.product.domain.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductCompleteCommandService {

    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;

    public ProductCompleteCommandService(ProductRepository productRepository,
                                         MemberRepository memberRepository) {
        this.productRepository = productRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void complete(Long productId, Long memberId) {
        // 1. 유효한 고객인지 체크.
        Member member = memberRepository.findById(memberId)
                .orElseThrow();
        member.activeMemberCheck();

        // 2. 상품 조회 및 존재 여부 체크
        Product product = productRepository.findById(productId)
                .orElseThrow();

        // 3. 상품 판매 완료 처리
        product.transactionComplete(member.getId());
    }
}
