package com.example.kiosk.required.lv4;

import java.util.List;

public class Menu {

    private String category;

    private List<MenuItem> menuItems;

    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void printMenuItemList() {
        int i = 1;
        for (MenuItem menuItem : menuItems) {
            System.out.println(i++ + ". " + menuItem.toString());
        }
        System.out.println(String.format("0. %-11s |  뒤로가기\n", "뒤로가기"));
    }

    public int getMenuItemsSize() {
        return this.menuItems.size();
    }
}
