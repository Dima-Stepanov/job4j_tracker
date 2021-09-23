package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * 1.3.1.Коллекция List,ArrayList
 * 5.Конвертация листа массивов в один лист Integer[#10037#127193]test
 *
 * @since 23.09.2021
 */
public class ConvertListTest {

    @Test
    public void whenTwoList() {
        List<int[]> in = new ArrayList<>();
        in.add(new int[]{1});
        in.add(new int[]{2, 3});
        List<Integer> expected = Arrays.asList(1, 2, 3);
        assertThat(ConvertList.convert(in), is(expected));
    }
}