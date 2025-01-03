package org.baseJava.spacePersonComparator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class spacePersonComparatorTests {
    SpacePersonComparator comparator = new SpacePersonComparator();

    public static Stream<Arguments> testCompere() {
        System.out.println("Let's start testCompere");
        Person p1 = new Person("Sasha", 35, 15);
        Person p2 = new Person("Susanna", 35, 15);
        Person p3 = new Person("Angelina", 35, 15);
        return Stream.of(
                Arguments.of(p1, p2, -1), // p1 < p2
                Arguments.of(p3, p1, 1)); // p3 > p1
    }

    @Test
    public void testCountOfSInName() {
        //arrange
        String name = "suSanna";
        int expected = 2;

        //act
        int actual = comparator.countOfSInName(name);

        //assert
        //Assertions.assertEquals(expected, actual, "Expected " + expected + " but got " + actual);
        assertThat(actual, is(expected));
    }

    @ParameterizedTest
    @MethodSource
    public void testCompere(Person p1, Person p2, int expected) {
        // act
        int actual = comparator.compare(p1, p2);
        // assert
        //Assertions.assertEquals(expected, actual);
        assertThat(actual, equalTo(expected));
    }
}
