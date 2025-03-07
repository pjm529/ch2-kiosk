package com.example.kiosk.required.lv5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Menu> menuList = new ArrayList<>();

        // Burgers
        menuList.add(new Menu("Burgers", List.of(
                new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거")
        )));

        // Drinks
        menuList.add(new Menu("Drinks", List.of(
                new MenuItem("Coke", 2.5, "탄산이 가득한 코카콜라"),
                new MenuItem("Cider", 2.5, "청량미 넘치는 사이다"),
                new MenuItem("Lemon juice", 3.0, "생과일 레몬이 들어간 레몬 쥬스"),
                new MenuItem("PowerAde", 3.0, "수분을 보충시켜 줄 파워에이드")
        )));

        // Desserts
        menuList.add(new Menu("Desserts", List.of(
                new MenuItem("Cheese Cake", 5.0, "꾸덕한 치즈가 들어간 치즈 케이크"),
                new MenuItem("Chocolate cake", 5.5, "초코가 흘러내리는 달콤한 초콜릿 케이크"),
                new MenuItem("IceCream", 3.0, "시원한 아이스크림"),
                new MenuItem("Cookie", 2.0, "갓 구운 바삭한 쿠키")
        )));

        new Kiosk(menuList).start();
    }
}