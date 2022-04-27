package ru.job4j.tracker.store;

import ru.job4j.tracker.model.Item;

import java.util.List;

/**
 * 1.2.6.ООА\П
 * 2.Singleton[#94606]
 *
 * @since 19.09.2021
 */
public final class SingleTracker {
    private static SingleTracker instance = null;
    private MemTracker memTracker = new MemTracker();

    private SingleTracker() {
    }

    /**
     * Создание обьекта SingelTracker
     *
     * @return SingleTracker
     */
    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    /**
     * 1.Доболвение заявок
     *
     * @param item Item
     * @return Item
     */
    public Item add(Item item) {
        return memTracker.add(item);
    }

    /**
     * 1.Получение массива всех заявок
     *
     * @return Item[]
     */
    public List<Item> findAll() {
        return memTracker.findAll();
    }

    /**
     * 1.Получение списка по имени
     *
     * @param key String
     * @return Item[]
     */
    public List<Item> findByName(String key) {
        return memTracker.findByName(key);
    }

    /**
     * Получение заявки по ID
     *
     * @param id int
     * @return Item
     */
    public Item findById(int id) {
        return memTracker.findById(id);
    }

    /**
     * Замена заявки по ID
     *
     * @param id   int ID Item
     * @param item new Item
     * @return boolean result
     */
    public boolean replace(int id, Item item) {
        return memTracker.replace(id, item);
    }

    /**
     * удаления заявки MemTracker.delete
     *
     * @param id int Item
     * @return boolean
     */
    public boolean delete(int id) {
        return memTracker.delete(id);
    }
}
