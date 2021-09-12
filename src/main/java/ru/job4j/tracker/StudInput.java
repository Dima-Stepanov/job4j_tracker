package ru.job4j.tracker;

/**
 * 1.2.4.Полиморфизм
 * 3.Интерфейс Input[#181092#127027]
 *
 * @since 13.10.2021
 */
public class StudInput implements Input {
    @Override
    public String askStr(String question) {
        return null;
    }

    @Override
    public int askInt(String question) {
        return 0;
    }
}
