package org.baseJava.exExceptions;

public class IllegalInputArgumentException extends IllegalArgumentException {
    public IllegalInputArgumentException(int number) {
        super("Введено не допустимое значение: " + number);
    }
}
