package org.baseJava.tax;

import java.util.Scanner;

public class Tax {

    public static void calculatorOfTax() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n Выберите операцию и введите её номер: \n" +
                    " 1. Добавить новый доход \n" +
                    " 2. Добавить новый расход \n" +
                    " 3. Выбрать систему налогообложения \n" +
                    "Для завершения программы введите end \n");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            } else {
                int operation = Integer.parseInt(input);
                Analyzer.analyzer(operation);
            }

        }
        System.out.println("Программа завершена!");
    }

}