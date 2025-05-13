package com.jeon.market.application.product.domain;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "PRODUCT")
@Access(AccessType.FIELD)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "MEMBER_ID", nullable = false)
    private Long memberId;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "CONTENT", nullable = false, length = 500)
    private String content;

    @Column(name = "PRICE")
    private BigInteger price;

}
