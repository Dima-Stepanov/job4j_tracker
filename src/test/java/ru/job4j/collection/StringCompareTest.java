package ru.job4j.collection;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

/**
 * 1.3.4. Сортировка
 * 3. Компаратор для строк[#35008#127202]
 *
 * @since 27.09.2021
 */
public class StringCompareTest {

    @Test
    public void whenStringsAreEqualsThenZero() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(rsl, is(0));
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void lastCharOfLeftLessThanRightShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "Petrova",
                "Petrove"
        );
        assertThat(rsl, lessThan(0));
    }
}