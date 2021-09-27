package ru.job4j.collection;

import java.util.Comparator;

/**
 * 1.3.4.Сортировка
 * 3.Компаратор для строк[#35008#127202]
 *
 * @since 27.09.2021
 */
public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int size = Math.min(left.length(), right.length());
        int rsl = 0;
        for (int i = 0; i < size; i++) {
            rsl = Character.compare(left.charAt(i), right.charAt(i));
            if (rsl != 0) {
                break;
            }
        }
        return rsl != 0 ? rsl : Integer.compare(left.length(), right.length());
    }
}
