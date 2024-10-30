package org.sortingOdd;

import java.util.Comparator;

public class SortingOdd implements Comparator<Integer> {

    public int[] sortArray(int[] array) {
        for (int i = 0; i <= array.length - 1; i++) {
            if (isOdd(array[i])) {
                for (int j = i + 1; j < array.length; j++) {
                    if (isOdd(array[j])) {
                        if (compare(array[i], array[j]) > 0) {
                            int shift = array[i];
                            array[i] = array[j];
                            array[j] = shift;
                        }
                    }
                }
            }
        }
        return array;
    }

    @Override
    public int compare(Integer num1, Integer num2) {
        return num1.compareTo(num2);
    }

    public boolean isOdd(int num) {
        return num % 2 != 0;
    }
}

