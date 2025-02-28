package org.javaCore.smallTask;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = ("My Pen Pen is black");
        List<String> list = Arrays.asList(s.split(" "));
        list.stream()
                .filter(word -> word.length() >= 3)
                .filter(x -> x.contains("P"))
                .distinct()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
