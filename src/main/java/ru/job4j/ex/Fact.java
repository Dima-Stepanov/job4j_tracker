package ru.job4j.ex;

/**
 * 1.2.5.Исключения
 * 0.2.Кидаем исключение-throw new RuntimeException[#219365#127035]
 *
 * @since 17.09.2021
 */

public class Fact {
    public static void main(String[] args) {
        new Fact().calc(-1);
    }

    public int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The parameter must not be negative");
        }
        int rsl = 1;
        for (int i = 0; i <= n; i++) {
            rsl *= i;
        }
        return rsl;
    }
}
