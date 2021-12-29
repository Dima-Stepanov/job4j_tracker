package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;

import java.util.List;

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
 * 1.2.5.Исключения
 * 1.Обеспечить бесперебойную работу приложения Tracker[#789#127037]
 * 2.Рефакторинг-Шаблон Декоратор для валидатора.[#34117#127042]
 *
 * @since 18.09.2021
 * @since 16.09.2021
 */
public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    /**
     * Метод init() - инициализирует приложение
     * и запускает выполнение различных пользовательских
     * действий
     *
     * @param input   Input interface
     * @param tracker Tracker
     * @param actions UserAction[]
     */
    public void init(Input input, Tracker tracker,
                     List<UserAction> actions/*UserAction[] actions*/) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select : ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0.. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    /**
     * Выводит на экран меню доступных пользовательских действий.
     */
    private void showMenu(List<UserAction> action) {
        out.println("Menu:");
        for (int i = 0; i < action.size(); i++) {
            out.println(i + ". " + action.get(i).name());

        }
    }

    /**
     * Запуск приложения Tracker
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new CreateAction(output),
                new FindAllAction(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new FindByIDAction(output),
                new FindByNameAction(output),
                new ExitAction()
        );
        new StartUI(output).init(input, tracker, actions);
    }
}
