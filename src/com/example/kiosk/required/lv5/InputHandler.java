package com.example.kiosk.required.lv5;

import java.io.BufferedReader;
import java.io.IOException;

public class InputHandler {

    public int getUserInput(BufferedReader br, int maxOption) throws IOException {
        // 반복문
        while (true) {
            try {
                System.out.print("번호를 선택해주세요 : ");
                int input = Integer.parseInt(br.readLine()); // 입력받은 값 parsing

                if (input >= 0 && input <= maxOption) { // 유효한 값이면 return
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
