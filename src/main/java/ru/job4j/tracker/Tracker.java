package ru.job4j.tracker;

import java.util.Arrays;

/**
 * 1.2.3Инкапсуляция
 * 5.Tracker-хранилище[#396#127071]
 *
 * @version 1
 * @since 11.10.2021
 */
public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    /**
     * 1.Доболвение заявок
     *
     * @param item Item
     * @return Item
     */
    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    /**
     * 1.Получение массива всех заявок
     *
     * @return Item[]
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    /**
     * 1.Получение списка по имени
     *
     * @param key String
     * @return Item[]
     */
    public Item[] findByName(String key) {
        Item[] itemNames = new Item[size];
        int step = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                itemNames[step++] = items[i];
            }
        }
        return Arrays.copyOf(itemNames, step);
    }

    /**
     * Получение заявки по ID
     *
     * @param id int
     * @return Item
     */
    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}