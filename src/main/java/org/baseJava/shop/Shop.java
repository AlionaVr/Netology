package org.baseJava.shop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Shop {
    public static void main(String[] args) throws FileNotFoundException {
        String[] products = {"Молоко", "Хлеб", "Гречневая крупа"};
        int[] amounts = new int[products.length];
        int[] prices = {50, 14, 80};
        showMenu(products, prices);
        communicateWithCustomer(amounts);
        calculateAndShowBill(products, amounts, prices);
    }


    private static void calculateAndShowBill(String[] products, int[] amounts, int[] prices) {
        double bill = 0;
        System.out.println("Ваша корзина:");
        for (int i = 0; i < amounts.length; i++) {
            if (amounts[i] != 0) {
                double priceForItems = amounts[i] * prices[i];
                bill += priceForItems;
                System.out.printf("%s %d шт %d руб/шт - %s руб в сумме \n", products[i], amounts[i], prices[i], priceForItems);
            }
        }
        System.out.println(bill);
    }


    private static void communicateWithCustomer(int[] amounts) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("F:/Projects/Netology/src/main/java/org/Shop/Order"));
        while (true) {
            System.out.println("Выберите номер товар и введите количество или введите `end`\n");
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            String[] parts = input.split(" ");
            if (parts.length != 2) {
                System.out.println("Проверьте введенные данные");
                continue;
            }
            int productNumber = Integer.parseInt(parts[0]) - 1;
            int productCount = 0;
            amounts[productNumber] += productCount + Integer.parseInt(parts[1]);
        }
    }

    private static void showMenu(String[] products, int[] prices) {
        System.out.println("Здравствуйте! Добро пожаловать в наш магазин. К сожалению, сегодня список продуктов ограничен\n");
        for (int i = 0; i < products.length; i++) {
            System.out.printf("%d. %s %d руб/шт\n", i + 1, products[i], prices[i]);
        }
    }
}




