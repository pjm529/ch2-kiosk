package com.example.kiosk.required.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Kiosk {

    private final List<Menu> menuList;

    private final BufferedReader br;

    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void start() {
        int menuNo;
        int menuItemNo;
        String input = "";

        try {
            while (true) {
                try {
                    System.out.println("\n[ MAIN MENU ]");
                    int i = 1;
                    for (Menu menu : menuList) {
                        System.out.println(i++ + ". " + menu.getCategory());
                    }
                    System.out.println("0. 종료\n");
                    System.out.print("번호를 선택해주세요 : ");

                    input = br.readLine();
                    menuNo = Integer.valueOf(input);

                    if (menuNo == 0) {
                        break;
                    } else if (menuNo > menuList.size()) { // 없는 번호 입력 시 exception
                        throw new NumberFormatException();
                    }

                    // 선택한 메뉴 가져오기
                    Menu selectMenu = menuList.get(menuNo - 1);
                    System.out.printf("\n[ %s MENU ]\n", selectMenu.getCategory().toUpperCase());
                    selectMenu.printMenuItemList(); // 메뉴 목록 출력

                    while (true) {
                        try {
                            System.out.print("번호를 선택해주세요 : ");
                            input = br.readLine();
                            menuItemNo = Integer.valueOf(input);

                            if (menuItemNo > selectMenu.getMenuItemsSize()) { // 없는 번호 입력 시 exception
                                throw new NumberFormatException();
                            } else if (menuItemNo != 0) {
                                MenuItem selectMenuItem = selectMenu.getMenuItems().get(menuItemNo - 1);
                                System.out.printf("선택한 메뉴 : %s | 가격 : W %s | 설명 : %s \n", selectMenuItem.getMenuNm(), selectMenuItem.getPrice(), selectMenuItem.getDesc());
                            }

                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("\n! 올바른 번호를 입력해주세요 !\n");
                        }
                    }

                } catch (NumberFormatException e) {
                    System.out.println("\n! 올바른 번호를 입력해주세요 !\n");
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("\n! 에러가 발생했습니다 !\n");
        }
        System.out.println("\n프로그램을 종료합니다.");
    }
}
