package ru.job4j.tracker;

/**
 * 1.2.4.Полиморфизм
 * 8.Реализация меню за счет шаблона стратегия.[#181780#127032]
 * 3 Delete item
 *
 * @since 16.10.2021
 */
public class DeleteAction implements UserAction {
    /**
     * name menu
     *
     * @return string
     */
    @Override
    public String name() {
        return "Delete item";
    }

    /**
     * Delete Item
     * menu 3
     *
     * @param input Input
     * @param tracker Tracker
     * @return boolean
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ===");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена успешно.");
        } else {
            System.out.println("Ошибка удаления заявки.");
        }
        return true;
    }
}
