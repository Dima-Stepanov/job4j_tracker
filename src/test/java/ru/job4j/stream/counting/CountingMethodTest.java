package ru.job4j.stream.counting;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Упражнения JavaCore
 * 1.4.2. Stream API
 * 2.2. Группировка элементов и подсчет количества.
 * Метод counting()
 * Test Клас реализации метода counting
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 30.06.2022
 */
public class CountingMethodTest {

    @Test
    public void groupAndCount() {
        Company c1 = new Company("Apple");
        Company c2 = new Company("Amazon");
        Company c3 = new Company("Microsoft");
        Worker w1 = new Worker(20, c1);
        Worker w2 = new Worker(25, c2);
        Worker w3 = new Worker(30, c2);
        Worker w4 = new Worker(35, c3);
        Worker w5 = new Worker(40, c3);
        Worker w6 = new Worker(45, c3);
        CountingMethod countingMethod = new CountingMethod();
        Map<String, Long> expect = Map.of(
                "Apple", 1L,
                "Amazon", 2L,
                "Microsoft", 3L
        );
        assertEquals(expect, countingMethod.groupAndCount(List.of(w1, w2, w3, w4, w5, w6)));
    }
}