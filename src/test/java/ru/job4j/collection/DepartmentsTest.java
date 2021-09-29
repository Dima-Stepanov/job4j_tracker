package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * 1.3.6.Контрольные вопросы
 * 2.Отсортировать департаменты.test
 *
 * @author Dmitry
 * @version 1
 * @since 29.09.2021
 */
public class DepartmentsTest {

    @Test
    public void whenMissed() {
        List<String> input = List.of("k1/sk1");
        List<String> expected = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expected));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> rsl = Departments.fillGaps(input);
        assertThat(rsl, is(expect));
    }

    @Test
    public void whenAddMissedAndNotMissed() {
        List<String> input = Arrays.asList("k1/sk1", "k1/sk2", "k2", "k2/sk3/ssk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1", "k1/sk2", "k2",
                "k2/sk3", "k2/sk3/ssk1");
        List<String> rsl = Departments.fillGaps(input);
        assertThat(rsl, is(expect));
    }

    @Test
    public void whenSortNaturalOrder() {
        List<String> input = Arrays.asList("k1/sk1", "k1", "k1/sk1/sk2", "k1/sk2");
        List<String> expected = Arrays.asList("k1", "k1/sk1", "k1/sk1/sk2", "k1/sk2");
        Departments.sortAsc(input);
        assertThat(input, is(expected));
    }
}