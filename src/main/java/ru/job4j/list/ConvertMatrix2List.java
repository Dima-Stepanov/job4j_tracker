package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.3.1.Коллекция List,ArrayList
 * 4.Конвертация двумерного массива в ArrayList[#48580#127194]
 *
 * @since 23.09.2021
 */
public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : array) {
            for (int cell : row) {
                list.add(cell);
            }
        }
        return list;
    }
}
