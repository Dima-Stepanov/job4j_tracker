package ru.job4j.tracker;

/**
 * 1.2.4.Полиморфизм
 * 8.Реализация меню за счет шаблона стратегия.[#181780#127032]
 * interface
 *
 * @since 16.10.2021
 */
public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
}