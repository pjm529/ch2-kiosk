package com.example.kiosk.challenge.lv1;

import java.io.BufferedReader;
import java.io.IOException;

public class InputHandler {

    public int getUserInput(BufferedReader br, int maxOption, boolean useZero) throws IOException {
        while (true) {
            System.out.print("번호를 선택해주세요 : ");
            String input = br.readLine();

            if (isValidInput(input, maxOption, useZero)) {
                return Integer.parseInt(input);
            }

            System.out.println("\n! 올바른 번호를 입력해주세요 !\n");
        }
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