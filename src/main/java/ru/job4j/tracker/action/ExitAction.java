package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.store.Store;

/**
 * 1.2.4.Полиморфизм
 * 8.Реализация меню за счет шаблона стратегия.[#181780#127032]
 * 9.1.Зависимость от System.out[#33568#127018]
 * 6 "Exit Program"
 *
 * @since 16.09.2021
 */
public class ExitAction implements UserAction {
    /**
     * name menu
     *
     * @return string
     */
    @Override
    public String name() {
        return "Exit Program";
    }

    /**
     * Exit Program
     * menu 6
     *
     * @param input   Input
     * @param tracker Store
     * @return boolean
     */
    @Override
    public boolean execute(Input input, Store tracker) {
        return false;
    }
}
