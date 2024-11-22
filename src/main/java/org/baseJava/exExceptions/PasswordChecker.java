package org.baseJava.exExceptions;

public class PasswordChecker {
    int minLength = -1;
    int maxRepeats = -1;

    public void setMinLength(int minLength) {
        //сеттер установки минимально допустимой длины пароля.
        if (minLength < 0) {
            throw new IllegalInputArgumentException(minLength);
        }
        this.minLength = minLength;
    }


    public void setMaxRepeats(int maxRepeats) {
        // сеттер установки максимально допустимого количества повторений символа подряд.
        if (maxRepeats <= 0) {
            throw new IllegalInputArgumentException(maxRepeats);
        }
        this.maxRepeats = maxRepeats;
    }

    boolean verify(String password) {
        if (minLength == -1 || maxRepeats == -1) {
            throw new IllegalStateException("Не установлены ограничения на длину или повторения пароля");
        }
        // проверка на длину и валидность повторений

        return (password.length() >= minLength) && verifyPasswordRepeatsCount(password);
    }


    private boolean verifyPasswordRepeatsCount(String password) {
        int[] counterArray = new int[password.length()];
        counterArray[0] = 1;
        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i) == password.charAt(i - 1)) {
                counterArray[i] = counterArray[i - 1] + 1;
                if (counterArray[i] > maxRepeats) {
                    return false;
                }
            } else {
                counterArray[i] = 1;
            }
        }
        return true;
    }
}
