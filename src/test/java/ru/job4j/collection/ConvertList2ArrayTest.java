package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConvertList2ArrayTest {

    @Test
    public void when7ElementsThen9() {
        int[][] result = ConvertList2Array.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expected = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expected));
    }
}