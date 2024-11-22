package org.javaCore.smallTask;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        long count = IntStream.of(-5, -2, -10, -5, 1, 2, 3, 4, 5)
                .filter(num -> num > 0)
                .count();
        System.out.println(count);
    }
}
