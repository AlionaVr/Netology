package org.baseJava.exExceptions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите значение minLength: ");
        int minLength = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите значение maxRepeats: ");
        int maxRepeats = Integer.parseInt(scanner.nextLine());

        PasswordChecker checker = new PasswordChecker();
        try {
            checker.setMinLength(minLength);
            checker.setMaxRepeats(maxRepeats);
        } catch (IllegalInputArgumentException e) { // добавила свое исключение, чтобы попрактиковаться в их создании)
            System.out.println("Ошибка: " + e.getMessage());
            System.exit(0);
        }
        acceptStrongPassword(scanner, checker);
    }

    private static void acceptStrongPassword(Scanner scanner, PasswordChecker checker) {
        while (true) {
            System.out.println("Введите пароль или end: ");
            String password = scanner.nextLine();
            if (password.toLowerCase().contains("end")) {
                break;
            } else {
                try {
                    if (checker.verify(password)) {
                        System.out.println("Подходит");
                    } else {
                        System.out.println("Не подходит");
                    }
                } catch (IllegalStateException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            }
        }
    }
}

