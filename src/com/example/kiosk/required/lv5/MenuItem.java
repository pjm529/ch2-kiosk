package com.example.kiosk.required.lv5;

public class MenuItem {
    private final String menuNm;
    private final double price;
    private final String desc;

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
        return String.format("%-13s | W %-4.1f | %s", menuNm, price, desc);
    }
}