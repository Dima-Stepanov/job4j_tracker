package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.3.1.Коллекция List,ArrayList
 * 5.Конвертация листа массивов в один лист Integer[#10037#127193]
 *
 * @since 23.09.2021
 */
public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] arrayInt : list) {
            for (int ell : arrayInt) {
                rsl.add(ell);
            }
        }
        return rsl;
    }
}
