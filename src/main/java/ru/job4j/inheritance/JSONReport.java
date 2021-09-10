package ru.job4j.inheritance;

/**
 * 1.2.2.Наследование
 * 4.Переопределение[#174890#127059]
 * 5.Аннотация@Override[#174891#127061]
 */
public class JSONReport extends TextReport {
    @Override
    public String generate(String name, String body) {
        return "{" + System.lineSeparator()
                + "name : " + name
                + System.lineSeparator()
                + "body : " + body
                + System.lineSeparator() + "}";
    }
}
