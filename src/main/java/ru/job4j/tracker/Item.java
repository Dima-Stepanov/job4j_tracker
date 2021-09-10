package ru.job4j.tracker;

/**
 * 1.2.2.Наследование
 * 2.Перегрузка конструктора[#173890#127063]
 *
 * @since 10.09.2021
 */
public class Item {
    private int id;
    private String name;

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
}