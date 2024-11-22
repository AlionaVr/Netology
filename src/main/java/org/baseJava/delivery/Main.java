package org.baseJava.delivery;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.startProgram();
    }

    private double totalBill = 0;

    public void startProgram() {
        Address point1 = new Address("Belarus", "Minsk");
        Address point2 = new Address("Russia", "Saint Petersburg");
        Address point3 = new Address("Lithuania", "Vilnius");
        Address point4 = new Address("Belarus", "Grodno");

        Map<Address, Double> costPerAddress = new HashMap<>();
        costPerAddress.put(point1, 54.10);
        costPerAddress.put(point2, 145.18);
        costPerAddress.put(point3, 65.20);
        costPerAddress.put(point4, 56.15);

        Set<String> setCountries = new HashSet<>();


        while (true) {
            System.out.println("Заполнение нового заказа.");
            System.out.println("Введите страну:");
            String country = checkIfExit();

            System.out.println("Введите город:");
            String city = checkIfExit();
            Address targetPoint = new Address(country, city);

            System.out.println("Введите вес (кг):");
            String input = checkIfExit();
            int weight = Integer.parseInt(input);

            if (checkAddress(targetPoint, costPerAddress)) {
                calculateCost(targetPoint, weight, costPerAddress);
                calculate_UniqueCountries(targetPoint, setCountries);
            }
        }
    }

    private boolean checkAddress(Address targetPoint, Map<Address, Double> costPerAddress) {
        if (!costPerAddress.containsKey(targetPoint)) {
            System.out.println("Доставки по этому адресу нет");
            return false;
        }
        return true;
    }

    private void calculateCost(Address targetPoint, int weight, Map<Address, Double> costPerAddress) {
        double costOfDelivery = costPerAddress.get(targetPoint) * weight;
        System.out.println("Стоимость доставки составит:" + costOfDelivery);

        totalBill += costOfDelivery;
        System.out.println("Общая стоимость всех доставок:" + totalBill);
    }

    private void calculate_UniqueCountries(Address targetPoint, Set<String> setCountries) {
        setCountries.add(targetPoint.country);
        System.out.println("Количество уникальных стран, в которые были оформлены доставки:" + setCountries.size());
    }

    private String checkIfExit() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.contains("end")) {
            System.out.println("Программа завершена");
            System.exit(0);
        }
        return input;
    }
}