package ru.job4j.collection;

/**
 * 1.3.2.Коллекция Set,HashSet
 * 1.Уникальные задачи.[#212653#127207]
 *
 * @since 23.09.2021
 */
public class Task {
    private String number;
    private String description;

    public Task(String number, String description) {
        this.number = number;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }
}
