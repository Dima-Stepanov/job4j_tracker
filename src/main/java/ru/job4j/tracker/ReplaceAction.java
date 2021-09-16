package ru.job4j.tracker;

/**
 * 1.2.4.Полиморфизм
 * 8.Реализация меню за счет шаблона стратегия.[#181780#127032]
 * 2 Edit item
 *
 * @since 16.10.2021
 */
public class ReplaceAction implements UserAction {
    /**
     * name menu
     *
     * @return string
     */
    @Override
    public String name() {
        return "Edit item";
    }

    /**
     * Edit Item
     * menu 2
     *
     * @param input   Input
     * @param tracker Tracker
     * @return boolean
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Edit Item ===");
        int id = input.askInt("Entar id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка изменена успешно.");
        } else {
            System.out.println("Ошибка замены заявки.");
        }
        return true;
    }
}
