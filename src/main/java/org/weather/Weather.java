package org.weather;

import java.util.Scanner;

public class Weather {

    public static void calculatorOfAverageWeather() {
        Scanner scanner = new Scanner(System.in);
        int [] temps = new int[31];
        boolean [] isFilled = new boolean[31];

        while (true) {
            System.out.println("Введите дату (день месяца) и температуру.\nДля завершение ввветдите 'end'");
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            if (input.equals(" ")) {
                System.out.println("Проверьте введенные данные");
            }
            String [] parts = input.split(" ");
            if (parts.length != 2) {
                System.out.println("Проверьте введенные данные");
                continue;
            }

            int day = Integer.parseInt(parts[0])-1;
            int t = Integer.parseInt(parts[1]);
            temps[day]=t;
            isFilled [day] = true;

            double sum = 0;
            for (int tt:temps) {
                sum+=tt;
            }
            int counter = 0;
            for (boolean yes : isFilled) {
                if (yes) {
                    counter++;
                }

            }
            System.out.println("Средняя температура месяца:" + (sum/counter));

        }

    }

}
