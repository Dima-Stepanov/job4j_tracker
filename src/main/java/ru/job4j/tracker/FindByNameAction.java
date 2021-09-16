package ru.job4j.tracker;

/**
 * 1.2.4.Полиморфизм
 * 8.Реализация меню за счет шаблона стратегия.[#181780#127032]
 * 5 "Find items by name"
 *
 * @since 16.10.2021
 */
public class FindByNameAction implements UserAction {
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
     * @param tracker Tracker
     * @return boolean
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find Item by NAME ===");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Заявки с именем: "
                    + name + " не найдены.");
        }
        return true;
    }
}
