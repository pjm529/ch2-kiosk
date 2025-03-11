package com.example.kiosk.challenge.lv2;

import java.util.stream.IntStream;

public enum DiscountType {
    VETERAN("국가유공자", 10), // 20% 할인
    SOLDIER("군인", 5),     // 15% 할인
    STUDENT("학생", 3),      // 10% 할인
    GENERAL("일반", 0);      // 할인 없음

    private final String value; // 값
    private final double discountRate; // 할인율

    DiscountType(String value, double discountRate) {
        this.value = value;
        this.discountRate = discountRate;
    }

    public String getValue() {
        return value;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public static void printDiscountTypeList() {
        IntStream.range(0, DiscountType.values().length)
                .forEach(i -> System.out.printf("%d. %-10s : %.1f%%%n",
                        i + 1,
                        DiscountType.values()[i].getValue(),
                        DiscountType.values()[i].getDiscountRate()));
        System.out.println();
    }

    public static int getDiscountTypeCount() {
        return DiscountType.values().length;
    }

    public static DiscountType getDiscountTypeByIndex(int index) {
        DiscountType[] types = DiscountType.values();

        if (index < 0 || index > types.length - 1) {
            throw new IllegalArgumentException("잘못된 인덱스입니다. 1부터 " + types.length + " 사이의 값을 입력하세요.");
        }

        return types[index]; // 1-based index 대응
    }
}
