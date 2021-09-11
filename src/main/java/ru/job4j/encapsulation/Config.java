package ru.job4j.encapsulation;

/**
 * 1.2.3.Инкапсуляция
 * 0.Что такое инкапсуляция.[#3818#127065]
 *
 * @since 11.09.2021
 */
public class Config {
    private String name;
    private int position;
    private String[] properties;

    public Config(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println(position);
    }

    private String search(String key) {
        return key;
    }
}
