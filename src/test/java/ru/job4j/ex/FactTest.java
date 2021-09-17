package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 1.2.5.Исключения
 * 0.3.Тестирование исключений с junit[#219366#127034]test
 *
 * @since 17.09.2021
 */
public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenCalcException() {
        new Fact().calc(-1);
    }
}