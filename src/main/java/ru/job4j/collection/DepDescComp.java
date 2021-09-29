package ru.job4j.collection;

import java.util.Comparator;

/**
 * 1.3.6.Контрольные вопросы.
 * 2.Отсортировать департаменты.
 * Обратная сортировка
 *
 * @author Dmitry
 * @version 1
 * @since 29.09.2021
 */
public class DepDescComp implements Comparator<String> {
    /**
     * Comparator reverse order
     *
     * @param left  First element
     * @param right Second element
     * @return -1, 0, 1.
     */
    @Override
    public int compare(String left, String right) {
        String[] lEl = left.split("/");
        String[] rEl = right.split("/");
        return lEl[0].equals(rEl[0]) ? left.compareTo(right) : right.compareTo(left);
    }
}
