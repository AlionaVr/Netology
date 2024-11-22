package org.baseJava.tasks;

public class Solution {
    public int solution(int number) {
        int sum = 0;
        for (int num = 0; num < number; num++) {
            if (num % 3 == 0 || num % 5 == 0) {
                sum += num;
            }
        }
        return sum;
    }
}
