package ru.job4j.tracker;

/**
 * 1.2.4.Полиморфизм
 * 8.Реализация меню за счет шаблона стратегия.[#181780#127032]
 * 1 Show all items
 *
 * @since 16.10.2021
 */
public class FindAllAction implements UserAction {
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
     * @param tracker Tracker
     * @return boolean
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Show all items ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Хранилище еще не содержит заявок");
        }
        return true;
    }
}
