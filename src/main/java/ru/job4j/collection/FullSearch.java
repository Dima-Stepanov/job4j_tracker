package ru.job4j.collection;

import java.util.Set;
import java.util.HashSet;
import java.util.List;

/**
 * 1.3.2.Коллекция Set,HashSet
 * 1.Уникальные задачи.[#212653#127207]
 *
 * @since 23.09.2021
 */
public class FullSearch {
    public static Set<String> extractNumber(List<Task> list) {
        Set<String> numbers = new HashSet<>();
        for (Task task : list) {
            numbers.add(task.getNumber());
        }
        return numbers;
    }
}
