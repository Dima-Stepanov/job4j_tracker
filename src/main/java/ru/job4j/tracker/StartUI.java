package ru.job4j.tracker;

/**
 * 1.2.4.Полиморфизм
 * 2.2.Реализация класса StartUI.Вывод меню[#500743]
 * 2.3.Реализация класса StartUI.Добавление заявки[#500744]
 * 2.4.Реализация класса StartUI.Вывод всех заявок[#500745]
 * 2.5.Реализация класса StartUI.Изменение заявки[#500746]
 * 2.6.Реализация класса StartUI.Удаление заявки[#500747]
 * 2.7.Реализация класса StartUI.Вывод заявки по id[#500748]
 * 2.8.Реализация класса StartUI.Вывод заявок по имени[#500749]
 * 4.1.Разрыв зависимости StartUI от Scanner.[#181778#127019]
 *
 * @since 12.09.2021
 */
public class StartUI {
    /**
     * Метод init() - инициализирует приложение
     * и запускает выполнение различных пользовательских
     * действий
     *
     * @param input   Input interface
     * @param tracker Tracker
     */
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Добавлена заявка: " + item);
            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Хранилище еще не содержит заявок");
                }
            } else if (select == 2) {
                System.out.println("=== Edit Item ===");
                int id = input.askInt("Entar id: ");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Заявка изменена успешно.");
                } else {
                    System.out.println("Ошибка замены заявки.");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                int id = input.askInt("Enter id: ");
                if (tracker.delete(id)) {
                    System.out.println("Заявка удалена успешно.");
                } else {
                    System.out.println("Ошибка удаления заявки.");
                }
            } else if (select == 4) {
                System.out.println("=== Find Item by ID ===");
                int id = input.askInt("Enter ID: ");
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Заявка с введенным id: "
                            + id + " не найдена.");
                }
            } else if (select == 5) {
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
            } else if (select == 6) {
                run = false;
            }
        }
    }

    /**
     * Выводит на экран меню доступных
     * пользовательских действий.
     */
    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);

        }
    }

    /**
     * Запуск приложения Tracker
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
