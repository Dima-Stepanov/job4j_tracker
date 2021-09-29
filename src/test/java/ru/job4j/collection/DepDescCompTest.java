package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

/**
 * 1.3.6.Контрольные вопросы
 * 2.Отсортировать департаменты.test
 * Компаратор тест.
 *
 * @author Dmitry
 * @version 1
 * @since 29.09.2021
 */
public class DepDescCompTest {

    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "k2/sk1/ssk2",
                "k2/sk1/ssk1"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenUpDepatmentGoBefore() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void sortDeportamentDesc() {
        List<String> input = Arrays.asList(
                "k1/ks1/kss1",
                "k3/ks3/kss3"
        );
        List<String> expect = Arrays.asList(
                "k3",
                "k3/ks3",
                "k3/ks3/kss3",
                "k1",
                "k1/ks1",
                "k1/ks1/kss1"
        );
        List<String> result = Departments.fillGaps(input);
        Departments.sortDesc(result);
        assertThat(result, is(expect));
    }
}