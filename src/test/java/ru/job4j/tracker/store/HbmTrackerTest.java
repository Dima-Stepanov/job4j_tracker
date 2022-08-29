package ru.job4j.tracker.store;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.model.Item;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 3. Мидл
 * 3.3. Hibernate
 * 3.3.4. Интеграционное тестирование
 * 1. Интеграционные тесты с Hqldb [#4746]
 * HbmTrackerTest тестирование HbmTracker.
 *
 * @author Dmitry Stepanov, user Dima_Nout
 * @since 29.05.2022
 */
public class HbmTrackerTest {
    private static HbmTracker hbmTracker;

    @Before
    public void setHdmTracker() {
        hbmTracker = new HbmTracker();
    }

    @Test
    public void whenAdd() {
        Item item = new Item();
        item.setName("item");
        hbmTracker.add(item);
        Item expect = hbmTracker.findById(item.getId());
        assertThat(item, is(expect));
    }

    @Test
    public void whenReplaceThenTrue() {
        Item item = new Item();
        item.setName("item");
        hbmTracker.add(item);
        item.setName("new Item");
        item.setDescription("test item replace");
        boolean result = hbmTracker.replace(item.getId(), item);
        assertTrue(result);
        assertThat(item, is(hbmTracker.findById(item.getId())));
    }

    @Test
    public void whenReplaceThenFalse() {
        Item item = new Item();
        item.setName("item");
        hbmTracker.add(item);
        item.setName("new Item");
        item.setDescription("test item replace");
        boolean result = hbmTracker.replace(99, item);
        assertFalse(result);
    }

    @Test
    public void whenDeleteTrue() {
        Item item = new Item();
        item.setName("item");
        hbmTracker.add(item);
        boolean result = hbmTracker.delete(item.getId());
        assertTrue(result);
        assertNull(hbmTracker.findById(item.getId()));
    }

    @Test
    public void whenDeleteFalse() {
        boolean result = hbmTracker.delete(99);
        assertFalse(result);
    }

    @Test
    public void whenFindAllThenTwoItem() {
        Item item = new Item();
        item.setName("item1");
        Item item1 = new Item();
        item.setName("item2");
        hbmTracker.add(item);
        hbmTracker.add(item1);
        List<Item> expected = List.of(item, item1);
        List<Item> result = hbmTracker.findAll();
        assertThat(expected, is(result));
    }

    @Test
    public void whenFindAllThenListIsEmpty() {
        List<Item> result = hbmTracker.findAll();
        assertTrue(result.isEmpty());
    }

    @Test
    public void whenFindByNameThenListTwoItem() {
        Item item = new Item();
        item.setName("item");
        Item item1 = new Item();
        item1.setName("item");
        hbmTracker.add(item);
        hbmTracker.add(item1);
        List<Item> expected = List.of(item, item1);
        List<Item> result = hbmTracker.findByName(item.getName());
        System.out.println(expected);
        System.out.println(result);
        assertThat(expected, is(result));
    }

    @Test
    public void whenFindByNameThenListOneItem() {
        Item item = new Item();
        item.setName("item");
        Item item1 = new Item();
        item1.setName("item1");
        hbmTracker.add(item);
        hbmTracker.add(item1);
        List<Item> expected = List.of(item);
        List<Item> result = hbmTracker.findByName(item.getName());
        assertThat(expected, is(result));
    }

    @Test
    public void whenFindById() {
        Item item = new Item();
        item.setName("item");
        hbmTracker.add(item);
        Item result = hbmTracker.findById(item.getId());
        assertThat(item, is(result));
    }

    @Test
    public void whenFindByIdThenNull() {
        Item result = hbmTracker.findById(99);
        assertNull(result);
    }
}