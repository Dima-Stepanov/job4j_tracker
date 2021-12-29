package ru.job4j.tracker.output;

import ru.job4j.tracker.output.Output;

/**
 * 1.2.4.Полиморфизм
 * 9.1.Зависимость от System.out[#33568#127018]
 * заглушка
 *
 * @since 16.09.2021
 */
public class StudOutput implements Output {
    private final StringBuilder buffer = new StringBuilder();

    @Override
    public void println(Object obj) {
        if (obj != null) {
            buffer.append(obj);
        } else {
            buffer.append("null");
        }
        buffer.append(System.lineSeparator());
    }

    @Override
    public String toString() {
        return buffer.toString();
    }
}
