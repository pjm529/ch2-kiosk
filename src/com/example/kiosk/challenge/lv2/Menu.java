package com.example.kiosk.challenge.lv2;

import java.util.List;

public class Menu {
    private final String category; // 카테고리
    private final List<MenuItem> menuItems; // menu Item 목록

    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }

    public String getCategory() {
        return category;
    }

    public int getMenuItemsSize() {
        return menuItems.size();
    }

    // MenuItem 목록 출력
    public void printMenuItemList() {
        menuItems.stream().forEach(menuItem -> System.out.println((menuItems.indexOf(menuItem) + 1) + ". " + menuItem));

        System.out.println("0. 뒤로가기\n");
    }

    // menuItem detail 출력
    public void printMenuItemDetails(int index) {
        MenuItem item = this.getMenuItemByIndex(index);
        System.out.printf("선택한 메뉴 : %s | 가격 : W %.1f | 설명 : %s\n",
                item.getMenuNm(), item.getPrice(), item.getDesc());
    }

    public MenuItem getMenuItemByIndex(int index) {
        return menuItems.get(index);
    }
}
