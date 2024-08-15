package org.tax;

import java.util.Scanner;

public class Analyzer {
    static int earnings;
    static int spendings;
    static int counterEarningsMinusSpendings=0;
    static int counterEarnings = 0;

    public static void analyzer(int operation) {
        Scanner scanner = new Scanner(System.in);
        switch (operation) {
            case 1:
                System.out.println("Введите сумму дохода:");
                String moneyStr = scanner.nextLine();
                int money = Integer.parseInt(moneyStr);
                earnings += money;
                break;
            case 2:
                System.out.println("Введите сумму расхода:");
                String costsStr = scanner.nextLine();
                int costs = Integer.parseInt(costsStr);
                spendings += costs;
                break;
            case 3:
                int taxEarnMinusSpend = taxEarningsMinusSpendings(earnings, spendings);
                int taxEarn = taxEarnings(earnings);
                if (taxEarningsMinusSpendings(earnings, spendings) < taxEarn) {
                    System.out.println("Мы советуем вам УСН доходы минус расходы");
                    System.out.println("Ваш налог составит (руб.): " + taxEarningsMinusSpendings(earnings, spendings));
                    System.out.println("Налог на другой системе (руб.): "
                            + taxEarn);
                    System.out.println(
                            "Экономия (руб.): " + (taxEarn - taxEarningsMinusSpendings(earnings, spendings)));
                } else if (taxEarningsMinusSpendings(earnings, spendings) > taxEarn) {
                    System.out.println("Мы советуем вам УСН доходы");
                    System.out.println("Ваш налог составит (руб.): " +
                            taxEarn);
                    System.out.println("Налог на другой системе (руб.): "
                            + taxEarningsMinusSpendings(earnings, spendings));
                    System.out.println("Экономия (руб.): "
                            + (taxEarningsMinusSpendings(earnings, spendings) - taxEarn));
                } else if (taxEarningsMinusSpendings(earnings, spendings) == taxEarn) {
                    System.out.println("Можете выбрать любую систему налогообложения");
                    System.out.println("Ваш УСН доходы составит (руб.): " +
                            taxEarn);
                    System.out.println("УСН доходы минус расходы (руб.): "
                            + taxEarningsMinusSpendings(earnings, spendings));
                }
                break;
            default:
                System.out.println("Такой операции нет");
        }
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        counterEarningsMinusSpendings++;
        System.out.println("Функция taxEarningsMinusSpendings вызывалась:" + counterEarningsMinusSpendings);
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarnings(int earnings) {
        int tax = earnings * 6 / 100;
        counterEarnings ++;
        System.out.println("Функция taxEarn вызывалась:" + counterEarnings);
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }
}