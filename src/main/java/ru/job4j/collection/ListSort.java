package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1.3.4.Сортировка
 * 0.Сортировка[#10096#127203]
 *
 * @since 27.09.2021
 */

public class ListSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 3, 4, 1, 2);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        int rsl = list.get(4).compareTo(3);
        System.out.println(rsl);
        list.sort(Collections.reverseOrder());
        System.out.println(list);
    }
}
