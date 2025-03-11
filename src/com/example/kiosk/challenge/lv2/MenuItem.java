package com.example.kiosk.challenge.lv2;

public class MenuItem {
    private final String menuNm; // 메뉴명
    private final double price; // 가격
    private final String desc; // 설명

    public MenuItem(String menuNm, double price, String desc) {
        this.menuNm = menuNm;
        this.price = price;
        this.desc = desc;
    }

    public String getMenuNm() {
        return menuNm;
    }

    public double getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return String.format("%-15s | W %-4.1f | %s", menuNm, price, desc);
    }
}