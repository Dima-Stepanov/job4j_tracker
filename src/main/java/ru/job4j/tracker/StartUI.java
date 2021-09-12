package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * 1.2.2.Наследование
 * 2.2.Реализация класса StartUI.Вывод меню[#500743]
 *
 * @since 12.09.2021
 */
public class StartUI {
    /**
     * Метод init() - инициализирует приложение
     * и запускает выполнение различных пользовательских
     * действий
     *
     * @param scanner Scanner(System.in)
     * @param tracker Tracker
     */
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.println("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select != 6) {
                System.out.println("Пользователь выбрал: " + select);
            } else {
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
