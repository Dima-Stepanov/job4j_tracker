package ru.job4j.strategy;

/**
 * 1.2.4.Полиморфизм
 * 7.Шаблон проектирования-Стратегия[#786#127021]
 *
 * @since 15.10.2021
 */
public class Triangle implements Shape {
    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return "  /\\   " + ln
                + " /  \\" + ln
                + "/____\\" + ln;
    }
}
