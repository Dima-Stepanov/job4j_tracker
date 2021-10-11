package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * 1.4.2. Stream API
 * 6.Тестовое задание из модуля коллекции
 * Lite переделать на Stream API.[#24260#127094]
 * Пример.
 * Основной класс. College,
 * в котором будет 2 метода поиска студента по аккаунту,
 * а также поиск предмета по аккаунту и имени предмета.
 * 1.4.3.Улучшенное Java API
 * 3.Optional в банковских переводах.[#214711#127085]
 *
 * @author Dima_Nout
 * @version 2
 * @since 10.10.2021
 * @since 11.10.2021
 */
public class College {
    /**
     * Финальное поле Map где хронятся все студенты и их оценки.
     */
    private final Map<Student, Set<Subject>> students;

    /**
     * Конструктор класса.
     *
     * @param students Map.
     */
    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    /**
     * Поиск студентов по уникальному полю account
     *
     * @param account ключ для поиска.
     * @return Student или null.
     */
    public Optional<Student> findByAccount(String account) {
        return students.keySet().stream()
                .filter(student -> student.getAccount().equals(account))
                .findFirst();
    }

    /**
     * Поиск предмета по аккаунту и имени предмета
     *
     * @param account ключ для поиска номер аккаунта.
     * @param name    ключ для поиска имя придмета.
     * @return Subject или null.
     */
    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Student> a = findByAccount(account);
            return students.get(a.get()).stream()
                    .filter(subject -> subject.getName().equals(name))
                    .findFirst();
    }
}
