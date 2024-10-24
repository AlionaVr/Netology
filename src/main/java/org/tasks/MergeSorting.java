package org.tasks;

import java.io.IOException;
import java.util.Arrays;

public class MergeSorting {
    public static void start() throws IOException {
        int[][] teams = {
                {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
                {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}
        };

        int[] nationalTeam = mergeAll(teams);
        System.out.println(Arrays.toString(nationalTeam)); // [51, 45, 31, 31, 30, 24, 22, 20, 18, 17]
    }

    /*** Метод для слияния всех команд в одну национальную*/
    public static int[] mergeAll(int[][] teams) {
        int[] team0 = new int[10];
        for (int i = 0; i <= teams.length - 1; i++) {
            team0 = merge(team0, teams[i]);
        }
        return team0;
    }

    /*** Метод для слияния двух команд в одну*/
    public static int[] merge(int[] teamA, int[] teamB) {
        int[] teamC = new int[10];
        int indexA = 0, indexB = 0;
        for (int i = 0; i < teamC.length; i++) {
            /*if (indexA == teamA.length) {
                teamC[i] = teamB[i - indexB];
                indexB++;
            } else if (indexB == teamB.length) {
                teamC[i] = teamA[i - indexA];
                indexA++;} */
            if (teamA[i - indexA] >= teamB[i - indexB]) {
                teamC[i] = teamA[i - indexA];
                indexB++;
            } else {
                teamC[i] = teamB[i - indexB];
                indexA++;
            }
        }
        return teamC;
    }
}

