package ru.job4j.pojo;

/**
 * 1.2.3.Инкапсуляция
 * 3.Массивы и модели.[#174892#127068]
 *
 * @since 11.09.2021
 */
public class Book {
    private String name;
    private int sheet;

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public int getSheet() {
        return sheet;
    }

    public Book setSheet(int sheet) {
        this.sheet = sheet;
        return this;
    }
}
