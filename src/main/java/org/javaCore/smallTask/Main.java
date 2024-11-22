package org.javaCore.smallTask;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] array = {50, 60, 70, 80, 90, 100};
        List<Integer> result = Arrays.stream(array)
                .filter(num -> num < 90)
                .map(num -> num + 10)
                .limit(3).boxed()
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
