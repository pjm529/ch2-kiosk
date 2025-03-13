package com.example.kiosk.challenge.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Kiosk {
    private final List<Menu> menuList; // 메뉴 목록

    private final InputHandler inputHandler; // inputHandler

    private final Order order; // 장바구니

    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
        this.inputHandler = new InputHandler();
        this.order = new Order();
    }

    public void start() {
        int menuListSize = menuList.size();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                this.printMainMenu(); // MAIN MENU 목록 출력 함수 실행

                int menuNo;
                if (order.isEmptyOrder()) { // 장바구니가 비어있을 경우
                    System.out.println(String.format("%-12s | 종료\n", "0. 종료"));
                    menuNo = inputHandler.getUserInput(br, menuListSize, true); // inputHandler 실행
                } else { // 장바구니에 물건이 있을 경우
                    this.printOrderMenu(); // ORDER MENU 출력
                    System.out.println(String.format("%-12s | 종료\n", "0. 종료"));
                    menuNo = inputHandler.getUserInput(br, menuListSize + 2, true); // inputHandler 실행
                }

                if (menuNo == 0) { // 0 이면 프로그램 종료
                    break;
                }

                if (!order.isEmptyOrder() && menuNo > menuListSize) { // ORDER MENU 선택시
                    if (menuNo == menuListSize + 1) { // Orders 버튼
                        this.processOrder(br); // 주문 프로세스 실행
                    } else { // Cancel 버튼
                        order.clearOrder(); // 장바구니 초기화
                        System.out.println("\n! 주문이 취소되었습니다 ! ");
                    }
                } else { // MAIN MENU 선택 시 1
                    this.processMenuSelection(br, menuList.get(menuNo - 1)); // 선택한 Menu 진행
                }
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
    }

    // ORDER MENU 목록 출력 함수
    private void printOrderMenu() {
        System.out.println("\n[ ORDER MENU ]");
        int i = menuList.size() + 1;
        System.out.println(String.format("%-13s | 장바구니를 확인 후 주문합니다.", i++ + ". Orders"));
        System.out.println(String.format("%-13s | 진행중인 주문을 취소합니다.", i + ". Cancel"));
    }

    // 주문 process
    private void processOrder(BufferedReader br) throws IOException {
        System.out.println("\n아래와 같이 주문 하시겠습니까?\n");
        order.printOrderList(); // 장바구니 List 출력
        order.printTotalPrice(); // 총 금액 출력

        System.out.println("\n1. 주문         2. 메뉴판\n");
        int no = inputHandler.getUserInput(br, 2, false);
        if (no == 1) { // 주문 진행
            order.order();
        }
    }

    // 메뉴 선택 후 process
    private void processMenuSelection(BufferedReader br, Menu menu) throws IOException {
        while (true) {
            System.out.printf("\n[ %s MENU ]\n", menu.getCategory().toUpperCase()); // 선택한 메뉴 출력

            menu.printMenuItemList(); // 선택한 메뉴의 menuItem List 출력
            int itemNo = inputHandler.getUserInput(br, menu.getMenuItemsSize(), true); // 입력받기

            if (itemNo != 0) { // 메뉴 선택시
                menu.printMenuItemDetails(itemNo - 1); // menuItem Detail 출력
                MenuItem menuItem = menu.getMenuItemByIndex(itemNo - 1); // menuItem 가져 옴

                System.out.println("\n위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인         2. 취소\n");
                int orderNo = inputHandler.getUserInput(br, 2, false); // 입력받기

                if (orderNo == 1) { // 장바구니 추가
                    System.out.println(menuItem.getMenuNm() + " 이 장바구니에 추가되었습니다.");
                    order.addOrder(menuItem);
                    break;
                }
                System.out.println("취소 되었습니다.");
            } else { // 돌아가기 선택 시
                break;
            }
        }
    }
}