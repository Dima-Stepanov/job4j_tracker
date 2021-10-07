package ru.job4j.stream;

import java.util.Objects;

/**
 * 1.4.2.Stream API
 * 1.Фильтрация учеников[#110058#127091]
 * модель данных Student
 *
 * @author Dmitry
 * @version 1
 * @since 07.10.2021
 */
public class Student {
    /**
     * Поля класса
     */
    private int score;
    private String surname;

    /**
     * Конструктор
     *
     * @param score   общий балл
     * @param surname Фамилия
     */
    public Student(int score, String surname) {
        this.score = score;
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score
                && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, surname);
    }
}
