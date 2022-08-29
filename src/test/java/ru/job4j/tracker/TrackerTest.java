package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;

/**
 * 1.2.3Инкапсуляция
 * 5.MemTracker-хранилище[#396#127071]test
 * 6.Метод замены заявки.MemTracker.replace[#211748#127066]test
 * 7.Метод удаления заявки MemTracker.delete[#211749#127070]test
 *
 * @version 1
 * @since 12.10.2021
 */
public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item();
        item.setName("test1");
        memTracker.add(item);
        Item result = memTracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenTestFindById() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        Item item = memTracker.add(bug);
        Item result = memTracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenTestFindAll() {
        MemTracker memTracker = new MemTracker();
        Item first = new Item();
        first.setName("First");
        Item second = new Item();
        second.setName("Second");
        memTracker.add(second);
        memTracker.add(first);
        Item result = memTracker.findAll().get(0);
        assertThat(result.getName(), is(second.getName()));
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        MemTracker memTracker = new MemTracker();
        Item first = new Item();
        first.setName("First");
        Item first1 = new Item();
        first1.setName("First");
        Item first2 = new Item();
        first2.setName("First");
        Item second = new Item();
        second.setName("Second");
        memTracker.add(first);
        memTracker.add(second);
        memTracker.add(first1);
        memTracker.add(first2);
        List<Item> result = memTracker.findByName(first.getName());
        assertThat(result.size(), is(3));
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        MemTracker memTracker = new MemTracker();
        Item first = new Item();
        first.setName("First");
        Item first1 = new Item();
        first1.setName("First");
        Item first2 = new Item();
        first2.setName("First");
        Item second = new Item();
        second.setName("Second");
        Item second1 = new Item();
        second1.setName("Second");
        memTracker.add(first);
        memTracker.add(second);
        memTracker.add(first1);
        memTracker.add(second1);
        memTracker.add(first2);
        List<Item> result = memTracker.findByName(second.getName());
        assertThat(result.get(1).getName(), is(second.getName()));
    }

    @Test
    public void whenReplace() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        memTracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        memTracker.replace(id, bugWithDesc);
        assertThat(memTracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        memTracker.add(bug);
        int id = bug.getId();
        memTracker.delete(id);
        assertThat(memTracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenDelete5ElementItem() {
        MemTracker memTracker = new MemTracker();
        Item first = new Item();
        first.setName("First");
        Item second = new Item();
        second.setName("Second");
        Item third = new Item();
        third.setName("Third");
        Item four = new Item();
        four.setName("Four");
        Item five = new Item();
        five.setName("Five");
        memTracker.add(first);
        memTracker.add(second);
        memTracker.add(third);
        memTracker.add(four);
        memTracker.add(five);
        int id = second.getId();
        memTracker.delete(id);
        assertThat(memTracker.findById(id), is(nullValue()));
    }
}