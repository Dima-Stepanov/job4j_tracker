package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.collection.ItemSortByNameRevesed;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * 1.3.4.Сортировка
 * 0.Сортировка[#10096#127203]
 *
 * @since 27.09.2021
 */
public class ItemSortByNameTest {
    @Test
    public void whenItemSortByName() {
        List<Item> items = Arrays.asList(
                new Item("B"),
                new Item("C"),
                new Item("Z"),
                new Item("A")
        );
        items.sort(new ItemSortByName());
        List<Item> expected = Arrays.asList(
                new Item("A"),
                new Item("B"),
                new Item("C"),
                new Item("Z")
        );
        assertThat(items, is(expected));
    }

    @Test
    public void whenItemSortByNameRevesed() {
        List<Item> items = Arrays.asList(
                new Item("B"),
                new Item("C"),
                new Item("Z"),
                new Item("A")
        );
        items.sort(new ItemSortByNameRevesed());
        List<Item> expected = Arrays.asList(
                new Item("Z"),
                new Item("C"),
                new Item("B"),
                new Item("A")
        );
        assertThat(items, is(expected));
    }
}