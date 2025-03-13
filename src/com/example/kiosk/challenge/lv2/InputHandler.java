package com.example.kiosk.challenge.lv2;

import java.io.BufferedReader;
import java.io.IOException;

public class InputHandler {

    private static final String EXIT_COMMAND = "exit";

    public String getMenuNmInput(BufferedReader br) throws IOException {
        while (true) {
            System.out.print("\n삭제하실 메뉴 이름을 입력해주세요 : ");
            String input = this.readInput(br);
            if (input == null || "".equals(input.replaceAll(" ", ""))) {
                System.out.println("\n! 메뉴명을 입력해주세요 !");
                continue;
            }
            return input;
        }
    }

    // 숫자 입력 받기
    public int getNumberInput(BufferedReader br, int maxOption, boolean useZero) throws IOException {
        while (true) {
            System.out.print("번호를 선택해주세요 : ");
            String input = this.readInput(br);

            if (isValidInput(input, maxOption, useZero)) {
                return Integer.parseInt(input);
            }

            System.out.println("\n! 올바른 번호를 입력해주세요 !\n");
        }
    }

    public String readInput(BufferedReader br) throws IOException {
        String input = br.readLine().trim();
        if (EXIT_COMMAND.equalsIgnoreCase(input)) {
            System.out.println("프로그램이 종료되었습니다.");
            System.exit(0);
        }
        return input;
    }

    // valid input
    private boolean isValidInput(String input, int maxOption, boolean useZero) {
        try {
            int number = Integer.parseInt(input);
            return useZero ? (number >= 0 && number <= maxOption) : (number > 0 && number <= maxOption);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}