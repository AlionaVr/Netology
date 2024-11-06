package org.tasks;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // Library.askTheLibrarian();
        // Tax.calculatorOfTax();
        // PatternInText.findPattern();
        //Weather.calculatorOfAverageWeather();
        //CrossOrZero.play();
        // BinarySearch.start();
        // Recursion.start();
        // MergeSorting.start();
        // System.out.println(new Solution().solution(20));
        //System.out.println(Sum.recursiveSum(5));

        int[] arr = {1, 8, 3, 2, 7, 1};
        System.out.println(Arrays.toString(BubbleSort.sort(arr)));
    }
}
