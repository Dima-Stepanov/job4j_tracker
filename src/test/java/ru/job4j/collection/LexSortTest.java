package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 1.3.4.Сортировка
 * 4.Сортировка номера[#221284#127204]
 *
 * @since 28.09.2021
 */
public class LexSortTest {

    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "1.1.2 Task.",
                "1.1. Task.",
                "2.3. Task."
        };
        String[] out = {
                "1.1. Task.",
                "1.1.2 Task.",
                "2.3. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }
}