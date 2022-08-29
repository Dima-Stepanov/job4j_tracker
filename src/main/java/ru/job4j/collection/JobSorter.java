package ru.job4j.collection;

import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.ItemSortByName;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1.3.4.Сортировка
 * 0.Сортировка[#10096#127203]
 *
 * @since 27.09.2021
 */
public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("B", 4),
                new Job("A", 5),
                new Job("C", 1)
        );
        System.out.println(jobs);
        Collections.sort(jobs);
        System.out.println(jobs);
        jobs.sort(new SortByNameJob());
        System.out.println(jobs);
        Item item5 = new Item();
        item5.setId(5);
        item5.setName("A");
        Item item4 = new Item();
        item4.setId(4);
        item4.setName("B");
        Item item3 = new Item();
        item3.setId(3);
        item3.setName("C");
        Item item2 = new Item();
        item2.setId(2);
        item2.setName("D");
        Item item1 = new Item();
        item1.setId(1);
        item1.setName("I");
        List<Item> items = Arrays.asList(
                item5,
                item4,
                item3,
                item2,
                item1
        );
        System.out.println(items);
        Collections.sort(items);
        System.out.println(items);
        items.sort(new ItemSortByName());
        System.out.println(items);
        items.sort(Collections.reverseOrder());
        System.out.println(items);
    }
}
