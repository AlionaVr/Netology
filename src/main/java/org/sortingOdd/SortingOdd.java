package org.sortingOdd;

public class SortingOdd {

    public int[] sortArray(int[] array) {
        for (int i = 0; i <= array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j] && array[i] % 2 == 1 && array[j] % 2 == 1) {
                    int shift = array[i];
                    array[i] = array[j];
                    array[j] = shift;
                }
            }
        }
        return array;
    }
}