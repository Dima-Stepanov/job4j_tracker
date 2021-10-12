package ru.job4j.stream.validation;

import java.util.Objects;

/**
 * 1.4.4.Контрольные вопросы
 * 2. Аттестация [#49777 #127086]
 * Модель Tuple содержит результаты:имя и баллы.
 * Этот класс используется как для учеников, так и для предметов.
 *
 * @author Dmitry
 * @version 1
 * @since 11.10.2021
 */
public class Tuple {
    private String name;
    private double score;

    public Tuple(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tuple tuple = (Tuple) o;
        return Double.compare(tuple.score, score) == 0 && Objects.equals(name, tuple.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
