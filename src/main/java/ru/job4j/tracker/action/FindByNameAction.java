package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.MemTracker;
import ru.job4j.tracker.store.Store;

import java.util.List;

/**
 * 1.2.4.Полиморфизм
 * 8.Реализация меню за счет шаблона стратегия.[#181780#127032]
 * 9.1.Зависимость от System.out[#33568#127018]
 * 5 "Find items by name"
 *
 * @since 16.09.2021
 */
public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    /**
     * name menu
     *
     * @return string
     */
    @Override
    public String name() {
        return "Find items by name";
    }

    /**
     * Find Item by NAME
     * menu 5
     *
     * @param input   Input
     * @param tracker Store
     * @return boolean
     */
    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Find Item by NAME ===");
        String name = input.askStr("Enter name: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Заявки с именем: "
                    + name + " не найдены.");
        }
        return true;
    }
}
