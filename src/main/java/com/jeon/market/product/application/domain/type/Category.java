package com.jeon.market.product.application.domain.type;

import lombok.Getter;

@Getter
public enum Category {
    // 생활/가전
    ELECTRONICS("전자제품"),
    HOME_APPLIANCES("가전제품"),
    FURNITURE("가구/인테리어"),
    KITCHEN("주방용품"),

    // 패션/미용
    CLOTHING("의류"),
    SHOES("신발"),
    BAG_ACCESSORY("가방/잡화"),
    BEAUTY("화장품/미용"),

    // 유아/아동
    BABY_GOODS("유아용품"),
    TOYS("장난감/취미"),

    // 디지털/게임
    MOBILE("스마트폰/태블릿"),
    COMPUTER("컴퓨터/노트북"),
    GAME_CONSOLE("게임기/게임"),

    // 스포츠/레저
    SPORTS_EQUIPMENT("운동용품"),
    OUTDOOR("캠핑/등산/낚시"),

    // 도서/음반
    BOOKS("도서"),
    MUSIC_MOVIE("음반/영화"),

    // 기타
    PET_SUPPLIES("반려동물용품"),
    FOOD("식품"),
    ETC("기타");

    Category(String label) {
        this.label = label;
    }

    private final String label;
}
