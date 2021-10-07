package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1.4.2.Stream API
 * 0.Stream API[#58166#127090]
 *
 * @author Dmitry
 * @version 1
 * @since 07.10.2021
 */
public class StreamArrayList {
    /**
     * Заполняем ArrayList Integer, получить поток,
     * отфильтровать положительными, записать в List.
     */
    public static void main(String[] args) {
        List<Integer> arrays = Arrays.asList(
                -1, 2, 3,
                -2, 5, -11,
                23, 7, -7
        );
        List<Integer> newArray = arrays.stream()
                .filter(i -> i >= 0)
                .collect(Collectors.toList());
    }
}
