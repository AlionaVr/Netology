package org.baseJava.patternInText;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class PatternInTextTests {

    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("aaabbaaabba", "aab", 2), // Обычный случай
                Arguments.of("aaaaa", "aa", 4),       // Перекрывающиеся паттерны
                Arguments.of("", "a", 0),             // Пустой текст
                Arguments.of("abc", "", 0),           // Пустой паттерн
                Arguments.of("abcdef", "xyz", 0));      // Нет совпадений

    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void testFindPattern(String string, String substring, int expectedCount) {
        PatternInText finder = new PatternInText(string, substring);
        //assumeTrue(!substring.isEmpty(), "Substring is empty, skipping test");
        // Act
        int actualCount = finder.findPattern();

        // Assert

        if (substring.isEmpty()) {
            assertThat("Pattern is Empty", substring, is(""));
        }

        assertThat("String don't contain the pattern", string, containsString(substring));
        assertThat(actualCount, is(expectedCount));

    }
}

