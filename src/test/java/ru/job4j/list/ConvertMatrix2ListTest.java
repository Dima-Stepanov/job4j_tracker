package ru.job4j.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * 1.3.1.Коллекция List,ArrayList
 * 4.Конвертация двумерного массива в ArrayList[#48580#127194]
 *
 * @since 23.09.2021
 */
public class ConvertMatrix2ListTest {

    @Test
    public void when3on3ArrayThenList9() {
        ConvertMatrix2List matrix2List = new ConvertMatrix2List();
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> result = matrix2List.toList(array);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(result, is(expected));
    }

    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List matrix2List = new ConvertMatrix2List();
        int[][] array = {
                {1, 2},
                {3, 4}
        };
        List<Integer> result = matrix2List.toList(array);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertThat(result, is(expected));
    }
}