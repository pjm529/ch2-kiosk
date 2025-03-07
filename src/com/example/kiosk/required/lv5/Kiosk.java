package com.example.kiosk.required.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Kiosk {
    private final List<Menu> menuList; // 메뉴 목록

    private final InputHandler inputHandler; // inputHandler

    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
        this.inputHandler = new InputHandler();
    }

    public void start() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                this.printMainMenu(); // MAIN MENU 목록 출력 함수 실행

                int menuNo = inputHandler.getUserInput(br, menuList.size()); // inputHandler 실행
                if (menuNo == 0) { // 0 이면 프로그램 종료
                    break;
                }
                processMenuSelection(br, menuList.get(menuNo - 1)); // 선택한 Menu 진행
            }
        } catch (IOException e) {
            System.out.println("\n! 에러가 발생했습니다 !\n");
        }
        System.out.println("\n프로그램을 종료합니다.");
    }

    // MAIN MENU 목록 출력 함수
    private void printMainMenu() {
        System.out.println("\n[ MAIN MENU ]");
        int i = 1;
        for (Menu menu : menuList) {
            System.out.println(i++ + ". " + menu.getCategory());
        }
        System.out.println("0. 종료\n");
    }

    // 메뉴 선택 후 process
    private void processMenuSelection(BufferedReader br, Menu menu) throws IOException {
        System.out.printf("\n[ %s MENU ]\n", menu.getCategory().toUpperCase()); // 선택한 메뉴 출력
        menu.printMenuItemList(); // 선택한 메뉴의 menuItem List 출력
        int itemNo = inputHandler.getUserInput(br, menu.getMenuItemsSize()); // 입력받기

        if (itemNo != 0) {
            menu.printMenuItemDetails(itemNo - 1); // menuItem Detail 출력
        }
    }
}