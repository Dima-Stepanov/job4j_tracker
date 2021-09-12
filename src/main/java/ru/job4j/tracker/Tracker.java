package ru.job4j.tracker;

import java.util.Arrays;

/**
 * 1.2.3Инкапсуляция
 * 5.Tracker-хранилище[#396#127071]
 * 6.Метод замены заявки.Tracker.replace[#211748#127066]
 * 7.Метод удаления заявки Tracker.delete[#211749#127070]
 * 8.Что такое валидация?[#246864]
 * @version 3
 * @since 12.10.2021
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
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
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
            item.setId(items[index].getId());
            items[index] = item;
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
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
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
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }
}