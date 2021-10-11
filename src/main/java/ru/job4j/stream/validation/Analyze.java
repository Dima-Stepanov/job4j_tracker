package ru.job4j.stream.validation;

import java.util.List;
import java.util.stream.Stream;

/**
 * 1.4.4.Контрольные вопросы
 * 2. Аттестация [#49777 #127086]
 * Класс Analyze получает статистику по аттестатам.
 *
 * @author Dmitry
 * @version 1
 * @since 11.10.2021
 */
public class Analyze {
    /**
     * Метод averageScore вычисляет общий средний балл по всем ученикам.
     *
     * @param stream Stream Pupil
     * @return double Общий средний бал по всем ученикам.
     */
    public static double averageScore(Stream<Pupil> stream) {
        return 0D;
    }

    /**
     * Метод averageScoreBySubject вычисляет средний балл ученика по его предметам.
     *
     * @param stream Stream Pupil
     * @return список из объекта Tuple (имя ученика и средний балл)
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return List.of();
    }

    /**
     * Метод averageScoreByPupil вычисляет средний балл по всем предметам для каждого ученика.
     *
     * @param stream Stream Pupil
     * @return список из объекта Tuple (имя ученика и средний балл)
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return List.of();
    }

    /**
     * Метод bestStudent - возвращает лучшего ученика
     *
     * @param stream Stream Pupil
     * @return Лучший ученик Tuple.
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return null;
    }

    /**
     * Метод bestSubject - возвращает предмет с наибольшим баллом для всех студентов.
     *
     * @param stream Stream Pupil
     * @return Возвращает объект Tuple
     * (имя предмета, сумма баллов каждого ученика по этому предмету).
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return null;
    }
}
