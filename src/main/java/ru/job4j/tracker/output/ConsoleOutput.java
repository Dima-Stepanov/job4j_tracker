package ru.job4j.tracker.output;

/**
 * 1.2.4.Полиморфизм
 * 9.1.Зависимость от System.out[#33568#127018]
 * Вывод на консоль.
 *
 * @since 16.09.2021
 */
public class ConsoleOutput implements Output {
    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }
}
