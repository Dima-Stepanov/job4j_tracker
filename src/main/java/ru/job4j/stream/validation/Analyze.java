package ru.job4j.stream.validation;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1.4.4.Контрольные вопросы
 * 2. Аттестация [#49777 #127086]
 * Класс Analyze получает статистику по аттестатам.
 *
 * @author Dmitry
 * @version 2
 * @since 12.10.2021
 */
public class Analyze {
    /**
     * Метод averageScore вычисляет общий средний балл по всем ученикам.
     *
     * @param stream Stream Pupil
     * @return double Общий средний бал по всем ученикам.
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(p -> p.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    /**
     * Метод averageScoreBySubject вычисляет средний балл ученика по его предметам.
     *
     * @param stream Stream Pupil
     * @return список из объекта Tuple (имя ученика и средний балл)
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(p -> new Tuple(
                                p.getName(),
                                p.getSubjects()
                                        .stream()
                                        .mapToInt(Subject::getScore)
                                        .average()
                                        .orElse(0D)
                        )
                ).collect(Collectors.toList());
    }

    /**
     * Метод averageScoreByPupil вычисляет средний балл предмета для всех учеников.
     *
     * @param stream Stream Pupil
     * @return список из объекта Tuple (имя ученика и средний балл)
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.getSubjects().stream())
                .collect(Collectors
                        .groupingBy(Subject::getName,
                                LinkedHashMap::new,
                                Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(m -> new Tuple(m.getKey(), m.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Метод bestStudent - возвращает лучшего ученика
     *
     * @param stream Stream Pupil
     * @return Лучший ученик Tuple.
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(p -> new Tuple(
                                p.getName(),
                                p.getSubjects()
                                        .stream()
                                        .mapToInt(Subject::getScore)
                                        .sum()
                        )
                ).max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }

    /**
     * Метод bestSubject - возвращает предмет с наибольшим баллом для всех студентов.
     *
     * @param stream Stream Pupil
     * @return Возвращает объект Tuple
     * (имя предмета, сумма баллов каждого ученика по этому предмету).
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.getSubjects().stream())
                .collect(Collectors
                        .groupingBy(Subject::getName,
                                LinkedHashMap::new,
                                Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(m -> new Tuple(m.getKey(), m.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }
}
