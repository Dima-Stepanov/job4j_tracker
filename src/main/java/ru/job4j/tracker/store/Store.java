package ru.job4j.tracker.store;

import ru.job4j.tracker.model.Item;

import java.util.List;

/**
 * 2.3.5. JDBC
 * 2. Трекер SQL
 * интерфейс нашего хранилища.
 *
 * @author Dmitry
 * @since 29.12.2021
 */
public interface Store extends AutoCloseable {
    Item add(Item item);

    boolean replace(int id, Item item);

    boolean delete(int id);

    List<Item> findAll();

    List<Item> findByName(String key);

    Item findById(int id);

    void init();
}
