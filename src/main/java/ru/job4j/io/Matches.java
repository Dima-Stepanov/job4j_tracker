package ru.job4j.io;

import java.util.Scanner;

/**
 * 1.2.4.Полиморфизм
 * 2.Scanner и чтение числа из консоли.[#179518#127024]
 *
 * @version 1
 * @since 12.10.2021
 */
public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";

            int matches;
            do {
                System.out.println(player + " введите число от 1 до 3:");
                matches = Integer.parseInt(input.nextLine());
            } while (matches > 3 || matches < 0 || count - matches < 0);
            turn = !turn;
            count -= matches;
            System.out.println("На столе осталось : " + count + " спичек");
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
