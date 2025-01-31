package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;

/**
 * 1.2.4.Полиморфизм
 * 8.Реализация меню за счет шаблона стратегия.[#181780#127032]
 * 9.1.Зависимость от System.out[#33568#127018]
 * 4 "Find item by id"
 *
 * @since 16.09.2021
 */
public class FindByIDAction implements UserAction {
    private final Output out;

    public FindByIDAction(Output out) {
        this.out = out;
    }

    /**
     * name menu
     *
     * @return string
     */
    @Override
    public String name() {
        return "Find item by id";
    }

    /**
     * Find Item by ID
     * menu 4
     *
     * @param input   Input
     * @param tracker Store
     * @return boolean
     */
    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Find Item by ID ===");
        int id = input.askInt("Enter ID: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Заявка с введенным id: "
                    + id + " не найдена.");
        }
        return true;
    }
}
