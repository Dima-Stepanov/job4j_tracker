package ru.job4j.collection;

import java.util.Comparator;

/**
 * 1.3.4.Сортировка
 * 4.Сортировка номера[#221284#127204]
 *
 * @since 28.09.2021
 */
public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftAr = left.split("[. ]");
        String[] rightAr = right.split("[. ]");
        int size = Math.min(leftAr.length, rightAr.length);
        int rsl = 0;
        for (int i = 0; i < size; i++) {
            rsl = Integer.compare(Integer.parseInt(leftAr[i]), Integer.parseInt(rightAr[i]));
            if (rsl != 0) {
                break;
            }
        }
        return rsl;
    }
}
