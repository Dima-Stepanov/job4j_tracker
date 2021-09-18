package ru.job4j.tracker;

/**
 * 1.2.5.Исключения
 * 1.Обеспечить бесперебойную работу приложения Tracker[#789#127037]
 * 2.Рефакторинг-Шаблон Декоратор для валидатора.[#34117#127042]
 *
 * @since 18.09.2021
 */
public class ValidateInput implements Input {
    private final Output out;
    private final Input in;

    public ValidateInput(Output out, Input input) {
        this.out = out;
        this.in = input;
    }

    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = in.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}
