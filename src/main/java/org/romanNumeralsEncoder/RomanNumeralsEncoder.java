package org.romanNumeralsEncoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RomanNumeralsEncoder {


    public String solution(int n) {

        Map<Integer, String> romanNumbers = new HashMap<>();
        romanNumbers.put(1, "I");
        romanNumbers.put(5, "V");
        romanNumbers.put(10, "X");
        romanNumbers.put(50, "L");
        romanNumbers.put(100, "C");
        romanNumbers.put(500, "D");
        romanNumbers.put(1000, "M");


        ArrayList<Integer> numbers = new ArrayList<>();
        while (n > 0) {
            numbers.add(n % 10);
            n = n / 10;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= numbers.size(); i++) {
            int index = numbers.size() - i;
            int num = numbers.get(index);
            int digit = (int) Math.pow(10, index);

            if (num != 0) {
                if (num == 4) {
                    result.append(romanNumbers.get(digit)).append(romanNumbers.get(5 * digit));
                } else if (num == 9) {
                    result.append(romanNumbers.get(digit)).append(romanNumbers.get((int) Math.pow(10, index + 1)));

                } else {
                    if (num >= 5) {
                        result.append(romanNumbers.get(5 * digit));
                        num -= 5;
                    }
                    for (int repits = 1; repits <= num; repits++) {
                        result.append(romanNumbers.get(digit));
                    }

                }

            }
        }
        return result.toString();
    }
}


