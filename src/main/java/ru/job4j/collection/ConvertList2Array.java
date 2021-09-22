package ru.job4j.collection;

import java.util.List;

/**
 * 1.3.1.Коллекция List,ArrayList
 * 3.Конвертация ArrayList в двухмерный массив[#10035#127195]
 *
 * @since 22.09.2021
 */
public class ConvertList2Array {
    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / cells);
        int[][] array = new int[groups][cells];
        int row = 0;
        int cell = 0;
        for (Integer num : list) {
            array[row][cell++] = num;
            if (cells == cell) {
                row++;
                cell = 0;
            }

        }
        return array;
    }
}
