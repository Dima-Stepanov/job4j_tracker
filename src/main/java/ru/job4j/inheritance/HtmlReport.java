package ru.job4j.inheritance;

/**
 * 1.2.2.Наследование
 * 4.Переопределение[#174890#127059]
 * 5.Аннотация@Override[#174891#127061]
 */
public class HtmlReport extends TextReport {
    @Override
    public String generate(String name, String body) {
        return "<h1>" + name + "</h1>"
                + "<br/>"
                + "<span>" + body + "</span>";
    }
}
