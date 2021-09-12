package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

/**
 * 1.2.4.Полиморфизм
 * 1.Чтение из консоли.Класс Scanner.[#179514#127025]
 *
 * @version 1
 * @since 12.10.2021
 */
public class MaicBall {
    public static void main(String[] args) {
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ->");
        Scanner input = new Scanner(System.in);
        String question = input.nextLine();
        System.out.println("Ваш вопрос : " + question);
        int answer = new Random().nextInt(3);
        switch (answer) {
            case 0 -> System.out.println("Да");
            case 1 -> System.out.println("Нет");
            default -> System.out.println("Може быть");
        }
    }
}
