package ru.job4j.collection;

import java.util.Comparator;

/**
 * 1.3.4.Сортировка
 * 0.Сортировка[#10096#127203]
 * 2.Комбинированный компаратор[#10036#127205]
 *
 * @since 27.09.2021
 */
public class SortByNameJob implements Comparator<Job> {
    @Override
    public int compare(Job first, Job second) {
        return first.getName().compareTo(second.getName());
    }
}
