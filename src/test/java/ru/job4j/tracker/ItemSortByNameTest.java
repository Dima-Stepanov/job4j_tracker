package ru.job4j.tracker;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.model.Item;

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
    private final Item itemA = new Item();
    private final Item itemB = new Item();
    private final Item itemC = new Item();
    private final Item itemZ = new Item();

    @Before
    public void createItem() {
        itemA.setName("A");
        itemB.setName("B");
        itemC.setName("C");
        itemZ.setName("Z");
    }

    @Test
    public void whenItemSortByName() {
        List<Item> items = Arrays.asList(
                itemB,
                itemC,
                itemZ,
                itemA
        );
        items.sort(new ItemSortByName());
        List<Item> expected = Arrays.asList(
                itemA,
                itemB,
                itemC,
                itemZ
        );
        assertThat(items, is(expected));
    }

    @Test
    public void whenItemSortByNameReversed() {
        List<Item> items = Arrays.asList(
                itemB,
                itemC,
                itemZ,
                itemA
        );
        items.sort(new ItemSortByNameRevesed());
        List<Item> expected = Arrays.asList(
                itemZ,
                itemC,
                itemB,
                itemA
        );
        assertThat(items, is(expected));
    }
}