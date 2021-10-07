package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 1.4.2.Stream API
 * 1.Фильтрация учеников[#110058#127091]
 * Основной класс
 *
 * @author Dmitry
 * @version 1
 * @since 07.10.2021
 */
public class School {
    /**
     * Сортировка учеников по условию отбора.
     *
     * @param students Общий список студентов.
     * @param predict  Условие отбора.
     * @return Список студентов соответствующие условию.
     */
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }
}
