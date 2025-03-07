package com.example.kiosk.required.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("\n[ SHAKESHACK MENU ]\n");
            System.out.println("1. ShackBurger  | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
            System.out.println("2. SmokeShack   | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
            System.out.println("3. Cheeseburger | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
            System.out.println("4. Hamburger    | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
            System.out.println("0. 종료          |  종료\n");

            int no;

            while (true) {
                try {
                    System.out.print("번호를 선택해주세요 : ");
                    String input = br.readLine();
                    no = Integer.valueOf(input);

                    if (no == 0) {
                        break;
                    }

                    switch (no) {
                        case 1:
                            System.out.println("ShackBurger 선택 완료.\n");
                            break;
                        case 2:
                            System.out.println("SmokeShack 선택 완료.\n");
                            break;
                        case 3:
                            System.out.println("Cheeseburger 선택 완료.\n");
                            break;
                        case 4:
                            System.out.println("Hamburger 선택 완료.\n");
                            break;
                        default:
                            throw new NumberFormatException();
                    }

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
