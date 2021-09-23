package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * 1.3.2.Коллекция Set,HashSet
 * 1.Уникальные задачи.[#212653#127207]test
 *
 * @since 23.09.2021
 */
public class FullSearchTest {

    @Test
    public void extractNumber() {
        List<Task> list = Arrays.asList(
                new Task("1", "one"),
                new Task("2", "two"),
                new Task("1", "one")
        );
        Set<String> expected = new HashSet<>(Arrays.asList("1", "2"));
        assertThat(FullSearch.extractNumber(list), is(expected));

    }
}