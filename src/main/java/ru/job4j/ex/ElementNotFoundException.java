package ru.job4j.ex;

/**
 * 1.2.5.Исключения
 * 0.4.Пользовательские исключения.[#219367#127041]
 *
 * @since 17.09.2021
 */
public class ElementNotFoundException extends Exception {
    public ElementNotFoundException(String message) {
        super(message);
    }
}
