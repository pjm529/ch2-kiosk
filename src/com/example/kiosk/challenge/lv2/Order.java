package com.example.kiosk.challenge.lv2;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<MenuItem> orderList;

    public Order() {
        this.orderList = new ArrayList<>();
    }

    // 장바구니 추가
    public void addOrder(MenuItem order) {
        this.orderList.add(order);
    }

    // 장바구니 비우기
    public void clearOrder() {
        this.orderList.clear();
    }

    // 장바구니 empty 여부
    public boolean isEmptyOrder() {
        return this.orderList.isEmpty();
    }

    // 메뉴 목록 출력 함수
    public void printOrderList() {
        System.out.println("[ Orders ]");
        orderList.stream().forEach(System.out::println);
    }

    // 총 금액 출력 함수
    public void printTotalPrice() {
        System.out.println("\n[ Total ]");
        System.out.printf("W %.1f\n", this.getTotalPrice());
    }

    // 총 금액 sum 함수
    public Double getTotalPrice() {
        return orderList.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    public void order(DiscountType discountType) {
        double discountRate = discountType.getDiscountRate(); // 할인율
        double totalPrice = this.getTotalPrice(); // 총 금액
        double finalPrice = totalPrice - (totalPrice * (discountRate / 100)); // 할인율이 적용된 최종금액

        System.out.printf("\n주문이 완료되었습니다. %.1f%% 할인이 적용되어 최종 금액은 W %.1f 입니다.\n", discountRate, finalPrice);
        this.clearOrder(); // 장바구니 초기화
    }
}