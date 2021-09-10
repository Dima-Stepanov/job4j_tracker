package ru.job4j.inheritance;

/**
 * 1.2.2.Наследование
 * 4.Переопределение[#174890#127059]
 */
public class HtmlReport extends TextReport {
    public String generate(String name, String body) {
        return "<h1>" + name + "</h1>"
                + "<br/>"
                + "<span>" + body + "</span>";
    }
}
