package com.example.kiosk.required.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Kiosk {

    private final List<MenuItem> menuItems;

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void start() {
        System.out.println("\n[ SHAKESHACK MENU ]\n");

        int i = 1;
        for (MenuItem menuItem : menuItems) {
            System.out.println(i++ + ". " + menuItem.toString());
        }
        System.out.println("0. 종료           |  종료\n");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int no;

            while (true) {
                try {
                    System.out.print("번호를 선택해주세요 : ");
                    String input = br.readLine();
                    no = Integer.valueOf(input);

                    if (no == 0) { // 0 이면 종료
                        break;
                    } else if (no > menuItems.size()) { // 없는 번호 입력 시 exception
                        throw new NumberFormatException();
                    }

                    MenuItem selectMenu = menuItems.get(no - 1);
                    System.out.printf("선택한 메뉴 : %s | 가격 : W %s | 설명 : %s \n\n", selectMenu.getMenuNm(), selectMenu.getPrice(), selectMenu.getDesc());

                } catch (NumberFormatException e) {
                    System.out.println("\n! 올바른 번호를 입력해주세요 !\n");
                }
            }

        } catch (IOException e) {
            System.out.println("\n! 에러가 발생했습니다 !\n");
        }

        System.out.println("\n프로그램을 종료합니다.");
    }
}
