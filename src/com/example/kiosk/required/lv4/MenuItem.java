package com.example.kiosk.required.lv4;

public class MenuItem {

    private String menuNm; // 메뉴명

    private double price; // 가격

    private String desc; // 설명

    public MenuItem(String menuNm, double price, String desc) {
        this.menuNm = menuNm;
        this.price = price;
        this.desc = desc;
    }

    public String getMenuNm() {
        return menuNm;
    }

    public void setMenuNm(String menuNm) {
        this.menuNm = menuNm;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return String.format("%-13s |  W %-4s | %s", menuNm, price, desc);
    }
}
