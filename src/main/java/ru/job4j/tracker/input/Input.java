package ru.job4j.tracker.input;

/**
 * 1.2.4.Полиморфизм
 * 3.Интерфейс Input[#181092#127027]
 *
 * @since 13.10.2021
 */
public interface Input {
    String askStr(String question);

    int askInt(String question);
}
