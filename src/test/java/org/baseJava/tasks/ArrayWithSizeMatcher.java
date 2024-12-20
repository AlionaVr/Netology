package org.baseJava.tasks;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class ArrayWithSizeMatcher extends TypeSafeMatcher<int[]> {
    private final int expectedSize;

    public ArrayWithSizeMatcher(int expectedSize) {
        this.expectedSize = expectedSize;
    }

    public static ArrayWithSizeMatcher arrayWithSize(int size) {
        return new ArrayWithSizeMatcher(size);
    }

    @Override
    protected boolean matchesSafely(int[] array) {
        return array.length == expectedSize;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("an array with size ").appendValue(expectedSize);
    }

}