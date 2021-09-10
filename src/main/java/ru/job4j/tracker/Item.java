package ru.job4j.tracker;

import java.time.LocalDateTime;

/**
 * 1.2.2.Наследование
 * 2.Перегрузка конструктора[#173890#127063]
 * 6.Date.Отображение даты.[#310017]
 *
 * @since 10.09.2021
 */
public class Item {
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }
}