package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1.4.2. Stream API
 * 5. Преобразование матрицы чисел в список чисел. [#110228 #127088]
 *
 * @author Dima_Nout
 * @version 1
 * @since 09.10.2021
 */
public class Matrix {
    /**
     * Преобразует матрицу чисел в список чисел.
     *
     * @param integers Матрица чисел.
     * @return Список чисел.
     */
    public List<Integer> matrixToList(Integer[][] integers) {
        return Arrays.stream(integers)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}
