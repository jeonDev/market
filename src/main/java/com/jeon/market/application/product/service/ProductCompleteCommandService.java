package com.jeon.market.application.product.service;

import com.jeon.market.application.member.service.MemberQueryResponse;
import com.jeon.market.application.member.service.MemberQueryService;
import com.jeon.market.application.product.domain.Product;
import com.jeon.market.application.product.domain.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductCompleteCommandService {

    private final MemberQueryService memberQueryService;
    private final ProductRepository productRepository;

    public ProductCompleteCommandService(MemberQueryService memberQueryService,
                                         ProductRepository productRepository) {
        this.memberQueryService = memberQueryService;
        this.productRepository = productRepository;
    }

    @Transactional
    public void complete(Long productId, Long memberId) {
        // 1. 유효한 고객인지 체크.
        MemberQueryResponse member = memberQueryService.findById(memberId);
        member.activeMemberCheck();

        // 2. 상품 및 등록자 체크
        Product product = productRepository.findById(productId)
                .orElseThrow();
        product.writerCheck(member.id());

        // 3. 상품 판매 완료 처리
        product.transactionComplete();
    }
}
