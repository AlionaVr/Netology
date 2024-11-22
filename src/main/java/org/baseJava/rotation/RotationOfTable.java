package org.baseJava.rotation;

import java.util.Random;
import java.util.Scanner;

public class RotationOfTable {
    public static final int SIZE = 8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] colors = new int[SIZE][SIZE];
        Random random = new Random();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }
        System.out.println("Начальная матрица");
        showMatrix(colors);
        while (true) {
            System.out.println("Для завершения введите 'end'. Введите угол вращения матрицы (90,180 или 360): ");
            String input = scanner.nextLine();
            if (input.contains("end")) {
                break;
            } else {
                int rotationAngle = Integer.parseInt(input);
                if (rotationAngle == 90 || rotationAngle == 180 || rotationAngle == 360) {
                    showMatrix(rotate(colors, rotationAngle));
                } else System.out.println("Проверьте введенное значение");
            }
        }
    }

    public static int[][] rotate(int[][] colors, int rotationAngle) {
        int[][] rotatedColors = new int[SIZE][SIZE];
        System.out.printf("Матрица повернута на %s градусов\n", (rotationAngle == 90) ? "90" : (rotationAngle == 180) ? "180" : "360");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (rotationAngle == 90) {
                    rotatedColors[i][j] = (colors[SIZE - 1 - j][i]);
                } else if (rotationAngle == 180) {
                    rotatedColors[i][j] = (colors[SIZE - 1 - i][SIZE - 1 - j]);
                } else rotatedColors[i][j] = (colors[i][j]);

                //int x =(rotationAngle == 90)?(SIZE - 1 - j):
                //        (rotationAngle == 180)?(SIZE - 1 - i):i;
                //int y = (rotationAngle == 90)?i:
                //        (rotationAngle == 180)?(SIZE - 1 - j):j;
                //rotatedColors[i][j]=colors[x][y];
                //System.out.format("%4d", rotatedColors[i][j]);
            }
        }
        System.out.println();
        return rotatedColors;
    }

    public static void showMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.format("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}

