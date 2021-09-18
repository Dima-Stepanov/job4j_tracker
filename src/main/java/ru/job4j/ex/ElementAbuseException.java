package ru.job4j.ex;

/**
 * 1.2.5.Исключения
 * 0.5.Иерархия исключений и множественный catch.[#219368#127033]
 */
public class ElementAbuseException extends ElementNotFoundException {
    public ElementAbuseException(String message) {
        super(message);
    }
}
