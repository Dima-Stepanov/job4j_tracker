package ru.job4j.tracker.store;

import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.2.3Инкапсуляция
 * 5.MemTracker-хранилище[#396#127071]
 * 6.Метод замены заявки.MemTracker.replace[#211748#127066]
 * 7.Метод удаления заявки MemTracker.delete[#211749#127070]
 * 8.Что такое валидация?[#246864]
 *
 * @version 3
 * @since 12.09.2021
 */
public class MemTracker implements Store {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    /**
     * 1.Доболвение заявок
     *
     * @param item Item
     * @return Item
     */
    @Override
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
    @Override
    public List<Item> findAll() {
        return items;
    }

    /**
     * Вернуть все заявки в реактивном стиле.
     *
     * @param observe Observe
     */
    @Override
    public void findAll(Observe<Item> observe) {
        for (Item item : items) {
            observe.receive(item);
        }
    }

    /**
     * 1.Получение списка по имени
     *
     * @param key String
     * @return Item[]
     */
    @Override
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
    @Override
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
    @Override
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
     * 7.Метод удаления заявки MemTracker.delete[#211749#127070]
     *
     * @param id int Item
     * @return boolean
     */
    @Override
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

    @Override
    public void close() throws Exception {
    }
}