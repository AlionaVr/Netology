package org.baseJava.sortingOdd;

public class Main {

    public static void main(String[] args) {

        int[] array1 = {7, 1};
        int[] array2 = {5, 8, 6, 3, 4};
        int[] array3 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        SortingOdd sort = new SortingOdd();

        printArray(sort.sortArray(array1));
        printArray(sort.sortArray(array2));
        printArray(sort.sortArray(array3));
    }

    public static void printArray(int[] array) {
        for (int j : array) {
            System.out.print(j);
        }
        System.out.println();
    }
}
