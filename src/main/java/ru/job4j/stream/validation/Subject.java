package ru.job4j.stream.validation;

/**
 * 1.4.4.Контрольные вопросы
 * 2. Аттестация [#49777 #127086]
 * Модель данных Subject описывает школьный предмет
 * и аттестационный балл ученика.
 *
 * @author Dmitry
 * @version 1
 * @since 11.10.2021
 */
public class Subject {
    private String name;
    private int score;

    public Subject(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
