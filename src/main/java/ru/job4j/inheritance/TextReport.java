package ru.job4j.inheritance;

/**
 * 1.2.2.Наследование
 * 4.Переопределение[#174890#127059]
 */
public class TextReport {
    public String generate(String name, String body) {
        return name + System.lineSeparator() + body;
    }
}
