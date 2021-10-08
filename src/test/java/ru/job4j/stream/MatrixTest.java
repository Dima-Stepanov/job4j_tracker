package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 1.4.2. Stream API
 * 5.Преобразование матрицы чисел в список чисел.[#110228#127088]test
 *
 * @author Dima_Nout
 * @version 1
 * @since 09.10.2021
 */
public class MatrixTest {

    @Test
    public void whenMatrixIntegerThenToListInteger() {
        Integer[][] integers = {
                {1, 2},
                {3, 4}
        };
        Matrix matrix = new Matrix();
        List<Integer> rsl = matrix.matrixToList(integers);
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenMatrixIntegerThenToListInteger2() {
        Integer[][] integers = {
                {1, 2, 5},
                {3, 4, 0}
        };
        Matrix matrix = new Matrix();
        List<Integer> rsl = matrix.matrixToList(integers);
        List<Integer> expected = List.of(1, 2, 5, 3, 4, 0);
        assertThat(rsl, is(expected));
    }
}