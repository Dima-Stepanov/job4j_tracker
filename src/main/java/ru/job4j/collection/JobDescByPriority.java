package ru.job4j.collection;

import java.util.Comparator;

/**
 * 1.3.4.Сортировка
 * 2.Комбинированный компаратор[#10036#127205]
 *
 * @since 27.09.2021
 */
public class JobDescByPriority implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return Integer.compare(o2.getPriority(), o1.getPriority());
    }
}
