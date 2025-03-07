package com.example.kiosk.required.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Kiosk {
    private final List<Menu> menuList;

    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public void start() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                this.printMainMenu(); // MAIN MENU 목록 출력 함수 실행

                int menuNo = this.getUserInput(br, menuList.size()); // inputHandler 실행
                if (menuNo == 0) {
                    break;
                }
                processMenuSelection(br, menuList.get(menuNo - 1));
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
        System.out.print("번호를 선택해주세요 : ");
    }

    // 메뉴 선택 후 process
    private void processMenuSelection(BufferedReader br, Menu menu) throws IOException {
        System.out.printf("\n[ %s MENU ]\n", menu.getCategory().toUpperCase());
        menu.printMenuItemList();
        int itemNo = this.getUserInput(br, menu.getMenuItemsSize()); // 입력받기

        if (itemNo != 0) {
            menu.printMenuItemDetails(itemNo - 1); // menuItem Detail 출력
        }
    }

    private int getUserInput(BufferedReader br, int maxOption) throws IOException {
        while (true) {
            try {
                System.out.print("번호를 선택해주세요 : ");
                int input = Integer.parseInt(br.readLine());

                if (input >= 0 && input <= maxOption) {
                    return input;
                } else {
                    System.out.println("\n! 올바른 번호를 입력해주세요 !\n");
                }
            } catch (NumberFormatException ignored) {
                System.out.println("\n! 올바른 번호를 입력해주세요 !\n");
            }
        }
    }
}