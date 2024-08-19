package org.crossOrZero;

import java.util.Scanner;

public class CrossOrZero {
    public static final int SIZE = 3;
    public static final char EMPTY = '-';
    public static final char CROSS = 'X';
    public static final char ZERO = '0';

    public static void play() {
        char[][] field = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {     //строки (внешний массив)
            for (int j = 0; j < SIZE; j++) { //элементы (внутренний массив)
                field[i][j] = EMPTY;
            }
        }
        Scanner scanner = new Scanner(System.in);
        boolean isCrossTurn = true;
        while (true) {
            System.out.println("Ходят " + (isCrossTurn ? "крестики" : "нолики") + ". Введите координаты");
            printField(field);
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            int x = Integer.parseInt(parts[0]) - 1;
            int y = Integer.parseInt(parts[1]) - 1;
            if (field[x][y] != EMPTY) {
                continue;
            }
            field[x][y] = isCrossTurn ? CROSS : ZERO;
            if (isWin(field, (isCrossTurn ? CROSS : ZERO))) {
                System.out.println("Выиграли " + (isCrossTurn ? "крестики" : "нолики") + "!");
                printField(field);
                break;
            } else {
                isCrossTurn = !isCrossTurn;
            }
        }
    }

    // ВНИМАНИЕ, ТОЛЬКО ДЛЯ 3x3
    public static boolean isWin(char[][] field, char player) {
        for (int i = 0; i < SIZE; i++) {
            // для горизонтали и вертикали
            if (field[i][0] == player && field[i][1] == player && field[i][2] == player ||
                    field[0][i] == player && field[1][i] == player && field[2][i] == player)
                return true;
        }
        // для диагоналей
        if (field[0][0] == player && field[1][1] == player && field[2][2] == player ||
                field[2][0] == player && field[1][1] == player && field[0][2] == player)
            return true;

        return false;

    }

    public static void printField(char[][] field) {
        for (char[] row : field) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
