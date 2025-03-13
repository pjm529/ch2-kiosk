package com.example.kiosk.required.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 메뉴 List
        List<MenuItem> menuList = new ArrayList<>();

        // 메뉴 추가
        menuList.add(new MenuItem("ShackBurger", 6.9 ,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem("SmokeShack", 8.9 ,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem("Cheeseburger", 6.9 ,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuList.add(new MenuItem("Hamburger", 5.4 ,"비프패티를 기반으로 야채가 들어간 기본버거"));

        int i = 1;
        System.out.println("\n[ SHAKESHACK MENU ]\n");
        for (MenuItem menuItem : menuList) {
            System.out.println(i++ + ". " +menuItem.toString());
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
                    } else if (no > menuList.size()) { // 없는 번호 입력 시 exception
                        throw new NumberFormatException();
                    }

                    MenuItem selectMenu = menuList.get(no - 1);
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
