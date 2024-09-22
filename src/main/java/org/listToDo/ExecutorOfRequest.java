package org.listToDo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExecutorOfRequest {
    List<String> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addToList() {
        System.out.println("Введите дело, которое хотите добавить");
        String business = scanner.nextLine();

        list.add(business);
        System.out.println("Добавлено!");
        showList();
    }

    public void showList() {
        if (list.size() == 0) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Ваш список дел: ");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + 1 + ". " + list.get(i));
            }
            System.out.println();
        }
    }

    public void removeBusinessByNumber() {
        System.out.println("Введите номер дела, которое хотите удалить");
        int numberOfBusiness = Integer.parseInt(scanner.nextLine());

        try {
            list.remove(numberOfBusiness - 1);
            System.out.println("Удалено!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Такого дела нет в списке");
        }
        showList();
    }

    public void removeBusinessByName() {
        System.out.println("Введите название дела, которое хотите удалить");
        String nameOfBusiness = scanner.nextLine();

//        list.stream()
//                .filter(business -> business.equalsIgnoreCase(nameOfBusiness))
//                .findFirst()
//                .ifPresent(business -> list.remove(business));

        boolean removable = false;
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String business = iterator.next();
            if (business.equalsIgnoreCase(nameOfBusiness)) {
                iterator.remove();
                removable = true;
            }
        }
        isRemoved(removable);
    }

    public void removeBusinessByWord() {
        System.out.println("Введите слово, содержащееся в удаляемых делах");
        String word = scanner.nextLine();

        boolean removed = false;
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String business = iterator.next();
            if (business.toLowerCase().contains(word.toLowerCase())) {
                iterator.remove();
                removed = true;
            }
        }
        isRemoved(removed);
    }

    public void isRemoved(boolean removed) {
        if (removed) {
            System.out.println("Удалено!");
            showList();
        } else {
            System.out.println("Такого дела нет в списке!");
            showList();
        }
    }

}
