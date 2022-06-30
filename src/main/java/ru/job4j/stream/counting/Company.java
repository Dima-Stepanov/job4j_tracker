package ru.job4j.stream.counting;

/**
 * Упражнения JavaCore
 * 1.4.2. Stream API
 * 2.2. Группировка элементов и подсчет количества. Метод counting()
 * Модель Company
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 30.06.2022
 */
public class Company {
    private String name;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
