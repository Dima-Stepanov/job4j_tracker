package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 1.4.1.Lambda
 * 5.Подсчет функции в диапазоне.[#24251#127079]test
 *
 * @author Dima_Nout
 * @version 1
 * @since 06.10.2021
 */
public class FunctionDiaposonTest {
    @Test
    public void whenLinerFunctionThenLinerResult() {
        List<Double> result = FunctionDiapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResult() {
        List<Double> result = FunctionDiapason.diapason(5, 8,
                x -> 2 * Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(51D, 73D, 99D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionExponentialResult() {
        List<Double> result = FunctionDiapason.diapason(5, 8,
                x -> 2 * Math.pow(2, x) + 1);
        List<Double> expected = Arrays.asList(65D, 129D, 257D);
        assertThat(result, is(expected));
    }
}