package org.baseJava.romanNumeralsEncoder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RomanNumeralsEncoderTest {
    static RomanNumeralsEncoder encoder = new RomanNumeralsEncoder();
    static Map<Integer, String> romanNumbers = encoder.romanNumbers;

    public static Stream<Arguments> provideRomanNumbers() {
        // Преобразуем Map в Stream<Arguments>
        return encoder.romanNumbers.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()) // Сортировка по ключу
                .map(entry -> Arguments.of(entry.getKey(), entry.getValue()));
    }

    public static Stream<Arguments> RandomChecks() {
        System.out.println("Let's start randomChecks test");
        return Stream.of(
                Arguments.of(4, "IV"),
                Arguments.of(1000, "M"),
                Arguments.of(1889, "MDCCCLXXXIX"),
                Arguments.of(89, "LXXXIX"),
                Arguments.of(1989, "MCMLXXXIX"));
    }


    @ParameterizedTest
    @MethodSource({"provideRomanNumbers", "RandomChecks"})
    public void ShouldReturnRoman(int arabicNumber, String expectedRomanNumber) {
        System.out.printf("Testing with arabicNumber=%d, expectedRomanNumber=%s%n", arabicNumber, expectedRomanNumber);

        // act
        String actualRomanNumber = encoder.solution(arabicNumber);

        // assert
        // Assertions.assertEquals(expectedRomanNumber, actualRomanNumber, "Conversion result is incorrect");
        assertThat(actualRomanNumber, allOf(notNullValue(), is(expectedRomanNumber)));
    }
}

