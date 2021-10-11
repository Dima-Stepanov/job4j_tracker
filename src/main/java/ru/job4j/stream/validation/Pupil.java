package ru.job4j.stream.validation;

import java.util.List;

/**
 * 1.4.4.Контрольные вопросы
 * 2. Аттестация [#49777 #127086]
 * Модель данных Pupil описывает ученика.
 *
 * @author Dmitry
 * @version 1
 * @since 11.10.2021
 */
public class Pupil {
    private String name;
    private List<Subject> subjects;

    public Pupil(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
