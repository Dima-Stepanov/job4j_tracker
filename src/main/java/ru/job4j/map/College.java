package ru.job4j.map;

import java.util.Map;
import java.util.Set;

/**
 * 1.4.2. Stream API
 * 6.Тестовое задание из модуля коллекции
 * Lite переделать на Stream API.[#24260#127094]
 * Пример.
 * Основной класс. College,
 * в котором будет 2 метода поиска студента по аккаунту,
 * а также поиск предмета по аккаунту и имени предмета.
 *
 * @author Dima_Nout
 * @version 1
 * @since 10.10.2021
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
    public Student findByAccount(String account) {
        return students.keySet().stream()
                .filter(student -> student.getAccount().equals(account))
                .findFirst()
                .orElse(null);
    }

    /**
     * Поиск предмета по аккаунту и имени предмета
     *
     * @param account ключ для поиска номер аккаунта.
     * @param name    ключ для поиска имя придмета.
     * @return Subject или null.
     */
    public Subject findBySubjectName(String account, String name) {
        Student a = findByAccount(account);
        if (a != null) {
            return students.get(a).stream()
                    .filter(subject -> subject.getName().equals(name))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод main для проверки результатов
     *
     * @param args null
     */
    public static void main(String[] args) {
        Map<Student, Set<Subject>> students = Map.of(new Student("Student", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                )
        );
        College college = new College(students);
        Student student = college.findByAccount("000001");
        System.out.println("Найденный студент: " + student);
        Subject english = college.findBySubjectName("000001", "English");
        System.out.println("Оценка по найденному предмету: " + english.getScore());
    }
}
