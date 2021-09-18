package ru.job4j.tracker;

/**
 * 1.2.5.Исключения
 * 1.Обеспечить бесперебойную работу приложения Tracker[#789#127037]
 *
 * @since 18.09.2021
 */
public class ValidateInput extends ConsoleInput {
    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}
