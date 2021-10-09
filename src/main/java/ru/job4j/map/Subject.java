package ru.job4j.map;

import java.util.Objects;

/**
 * 1.4.2. Stream API
 * 6.Тестовое задание из модуля коллекции
 * Lite переделать на Stream API.[#24260#127094]
 * Пример.
 * Модель данных.Subject - модель описывает изучаемый предмет,
 * хранится имя предмета и оценка по нему.
 *
 * @author Dima_Nout
 * @version 1
 * @since 10.10.2021
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

    public Subject setName(String name) {
        this.name = name;
        return this;
    }

    public int getScore() {
        return score;
    }

    public Subject setScore(int score) {
        this.score = score;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Subject subject = (Subject) o;
        return Objects.equals(name, subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Subject{"
                + "name='" + name + '\''
                + ", score=" + score
                + '}';
    }
}
