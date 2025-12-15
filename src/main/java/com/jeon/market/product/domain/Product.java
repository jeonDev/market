package com.jeon.market.product.domain;

import com.jeon.market.product.domain.type.Category;
import com.jeon.market.product.domain.type.ProductStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "PRODUCT")
@Access(AccessType.FIELD)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "MEMBER_ID", nullable = false)
    private Long memberId;

    @Enumerated(EnumType.STRING)
    @Column(name = "CATEOGRY", nullable = false)
    private Category category;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "CONTENT", nullable = false, length = 500)
    private String content;

    @Column(name = "PRICE")
    private BigInteger price;

    @Column(name = "VIEW_COUNT")
    private Integer viewCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private ProductStatus status;

    public void transactionComplete() {
        this.status = ProductStatus.COMPLETE;
    }

}
