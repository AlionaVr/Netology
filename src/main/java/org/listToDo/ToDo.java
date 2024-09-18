package org.listToDo;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ToDo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        ExecutorOfRequest assistant = new ExecutorOfRequest();

        while (true) {
            System.out.println("""
                    Для выбора действия введите номер из списка:
                    0. Выход из программы
                    1. Добавить дело
                    2. Показать дела
                    3. Удалить дело по номеру
                    4. Удалить дело по названию
                    5. Удалить все дела, содержащие ключевое слово
                    Ваш выбор:""");
            int request;
            try {
                request = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Проверьте введенные данные.");
                continue;
            }
            if (request == 0) {
                break;
            }
            switch (request) {
                case 1:
                    assistant.addToList();
                    break;
                case 2:
                    assistant.showList();
                    break;
                case 3:
                    assistant.removeBusinessByNumber();
                    break;
                case 4:
                    assistant.removeBusinessByName();
                    break;
                case 5:
                    assistant.removeBusinessByWord();
                    break;
                default:
                    System.out.println("Введено неверное число");
                    break;

            }
        }
    }
}
