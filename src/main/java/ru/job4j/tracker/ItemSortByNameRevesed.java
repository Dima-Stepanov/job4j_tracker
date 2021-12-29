package ru.job4j.tracker;

import ru.job4j.tracker.model.Item;

import java.util.Comparator;

/**
 * 1.3.4.Сортировка
 * 0.Сортировка[#10096#127203]
 *
 * @since 27.09.2021
 */
public class ItemSortByNameRevesed implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
