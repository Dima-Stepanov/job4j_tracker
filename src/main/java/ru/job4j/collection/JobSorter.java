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
        List<Item> items = Arrays.asList(
                new Item(5, "A"),
                new Item(4, "B"),
                new Item(3, "C"),
                new Item(2, "D"),
                new Item(1, "I")
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
