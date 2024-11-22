package org.baseJava.boxes;

public class DoubleBox<T> {

    private RandomBox<T> first;
    private RandomBox<T> second;
    private int SIZE = 0;

    public boolean put(int key, T value) {
        if (SIZE >= 2) {
            return false;
        } else if (SIZE == 0) {
            first = new RandomBox<>(key, value);
        } else if (SIZE == 1) {
            second = new RandomBox<>(key, value);
        }
        SIZE++;
        return true;
    }

    public T get(int key) {
        if (first != null && first.tryUnlock(key) != null) {
            return first.getValue();
        } else if (second != null && second.tryUnlock(key) != null) {
            return second.getValue();
        }
        return null;
    }

    public int size() {
        return SIZE;
    }
}

