package ru.job4j.tracker;

import java.util.Scanner;

/**
 * 1.2.4.Полиморфизм
 * 4.1.Разрыв зависимости StartUI от Scanner.[#181778#127019]
 * Работа с класса Scaner
 *
 * @since 14.10.2021
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
