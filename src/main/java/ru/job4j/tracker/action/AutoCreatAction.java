package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;

/**
 * 2.4.3. Профилирование приложения.
 * 1. Профилирование. [#1591].
 * Данный класс добавляет указанное количество заявок.
 *
 * @author Dmitry
 * @since 20.01.2022
 */
public class AutoCreatAction implements UserAction {
    private final Output out;

    public AutoCreatAction(Output out) {
        this.out = out;
    }

    /**
     * name menu
     *
     * @return string.
     */
    @Override
    public String name() {
        return "Auto add new itmes";
    }

    /**
     * Добавляет количество заявок введенных с клавиатуры.
     *
     * @param input   Input
     * @param tracker Store
     * @return true.
     */
    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Auto Create new Item ===");
        int size = input.askInt("Enter number of new Item:");
        for (int i = 1; i < size; i++) {
            Item item = new Item("name_" + i);
            tracker.add(item);
            out.println("Добавление заявки: " + item);
        }
        return true;
    }
}
