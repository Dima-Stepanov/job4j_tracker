package ru.job4j.pojo;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * 1.2.3.Инкапсуляция
 * 4.Сравнение моделей.Метод equals[#174893#127069]test
 * @since 11.09.2021
 */
public class LicenseTest {

    @Test
    public void testEquals() {
        License first = new License();
        first.setModel("audi");
        License second = new License();
        second.setModel("audi");
        assertThat(first, is(second));
    }
}