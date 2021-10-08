package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 1.4.2.Stream API
 * 1.Фильтрация учеников[#110058#127091]
 * Основной класс
 * 4.Преобразование List в Map.[#110226#127089]
 *
 * @author Dmitry
 * @version 1
 * @since 07.10.2021
 * @since 09.10.2021
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

    /**
     * Преобразование списка Sudent в Map
     * key Student surname
     * Value object Student
     *
     * @param students List<Student>
     * @return Map
     */
    public Map<String, Student> toMap(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(
                        student -> student.getSurname(),
                        student -> student,
                        (s1, s2) ->
                                new Student(
                                        Math.max(s1.getScore(), s2.getScore()),
                                        s1.getSurname())
                ));
    }
}
