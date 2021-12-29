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
 * 1 Show all items
 *
 * @since 16.09.2021
 */
public class FindAllAction implements UserAction {
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    /**
     * name menu
     *
     * @return string
     */
    @Override
    public String name() {
        return "Show all items";
    }

    /**
     * FindAllItem
     * menu 1
     *
     * @param input   Input
     * @param tracker Sracker
     * @return boolean
     */
    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Show all items ===");
        List<Item> items = tracker.findAll();
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Хранилище еще не содержит заявок");
        }
        return true;
    }
}
