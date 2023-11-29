package org.example.calculator.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int readOperand() {
        System.out.println("양수를 입력하세요: ");
        return scanner.nextInt();
    }

    public static String readOperator() {
        System.out.println("연산자 기호를 입력하세요: ");
        return scanner.nextLine();
    }

}
