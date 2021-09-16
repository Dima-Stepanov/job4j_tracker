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
 * 4.2.Статические методы.[#181779#127029]
 * 8.Реализация меню за счет шаблона стратегия.[#181780#127032]
 *
 * @since 14.10.2021
 */
public class StartUI {
    /**
     * Метод init() - инициализирует приложение
     * и запускает выполнение различных пользовательских
     * действий
     *
     * @param input   Input interface
     * @param tracker Tracker
     * @param actions UserAction[]
     */
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select : ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    /**
     * Выводит на экран меню доступных пользовательских действий.
     */
    private void showMenu(UserAction[] action) {
        System.out.println("Menu:");
        for (int i = 0; i < action.length; i++) {
            System.out.println(i + ". " + action[i].name());

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
        UserAction[] actions = {
                new CreateAction(),
                new FindAllAction(),
                new ReplaceAction(),
                new DeleteAction(),
                new FindByIDAction(),
                new FindByNameAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}
