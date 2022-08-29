package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;

/**
 * 1.2.4.Полиморфизм
 * 8.Реализация меню за счет шаблона стратегия.[#181780#127032]
 * 9.1.Зависимость от System.out[#33568#127018]
 * 0 Add new Item
 *
 * @since 16.09.2021
 */
public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    /**
     * name menu
     *
     * @return string
     */
    @Override
    public String name() {
        return "Add new Item";
    }

    /**
     * Create new Item
     * menu 0
     *
     * @param input   Input
     * @param tracker Store
     * @return boolean
     */
    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item();
        item.setName(name);
        tracker.add(item);
        out.println("Добавлена заявка: " + item);
        return true;
    }
}
