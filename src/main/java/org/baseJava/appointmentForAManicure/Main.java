package org.baseJava.appointmentForAManicure;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        List<String> firstClients = List.of("Anya", "Sveta", "Olya", "Alexandra", "Ruslana", "Olesya", "Vika");
        Queue<String> queue = new LinkedList<>(firstClients);

        while (!queue.isEmpty()) {
            String client = queue.poll();
            System.out.println(client + " сделал новый маникюр");
            if (Math.random() < 0.5 && !queue.isEmpty()) { // проверка условия, которое срабатывает с 50% вероятностью
                queue.offer("a friend of " + client);

            } else {
                System.out.println("друг не записался");
            }
            System.out.println(queue);
        }
    }
}
