package org.baseJava.tasks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class BubbleSortTests {
    BubbleSort sorting = new BubbleSort();

    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 8, 3, 2, 7, 1}, new int[]{1, 1, 2, 3, 7, 8}), // Обычный случай
                Arguments.of(new int[]{10, 85, -1000, 0, -185}, new int[]{-1000, -185, 0, 10, 85}));
    }

    @Test
    public void ensureInitialSize() {
        int[] arr = sorting.sort(new int[]{1, 8, 3, 2, 7, 1});

        assertThat("size is correct", arr, ArrayWithSizeMatcher.arrayWithSize(6));
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void testSort(int[] arr, int[] expected) {
        //act
        int[] actual = sorting.sort(arr);

        //assert
        assertThat(actual, is(expected));
    }

}
