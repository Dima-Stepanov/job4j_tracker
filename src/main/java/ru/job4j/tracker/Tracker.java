package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1.2.3Инкапсуляция
 * 5.Tracker-хранилище[#396#127071]
 * 6.Метод замены заявки.Tracker.replace[#211748#127066]
 * 7.Метод удаления заявки Tracker.delete[#211749#127070]
 * 8.Что такое валидация?[#246864]
 *
 * @version 3
 * @since 12.09.2021
 */
public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    /**
     * 1.Доболвение заявок
     *
     * @param item Item
     * @return Item
     */
    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    /**
     * 1.Получение массива всех заявок
     *
     * @return Item[]
     */
    public List<Item> findAll() {
        return items;
    }

    /**
     * 1.Получение списка по имени
     *
     * @param key String
     * @return Item[]
     */
    public List<Item> findByName(String key) {
        List<Item> itemNames = new ArrayList<>();
        for (Item item : items) {
            if (key.equals(item.getName())) {
                itemNames.add(item);
            }
        }
        return itemNames;
    }

    /**
     * Получение заявки по ID
     *
     * @param id int
     * @return Item
     */
    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    /**
     * Замена заявки по ID
     *
     * @param id   int ID Item
     * @param item new Item
     * @return boolean result
     */
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.remove(index);
            items.add(index, item);
        }
        return rsl;
    }

    /**
     * 7.Метод удаления заявки Tracker.delete[#211749#127070]
     *
     * @param id int Item
     * @return boolean
     */
    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
        }
        return rsl;
    }

    /**
     * Возвращает Index по ID
     *
     * @param id int item
     * @return index int
     */
    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                rsl = i;
            }
        }
        return rsl;
    }
}