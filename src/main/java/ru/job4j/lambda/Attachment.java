package ru.job4j.lambda;

/**
 * 1.4.1.Lambda
 * 1.1.Анонимные классы[#214142#127080]
 *
 * @author Dmitry
 * @version 1
 * @since 04.10.2021
 */
public class Attachment {

    private String name;
    private int size;

    public Attachment(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Attachment{"
                + "name='" + name
                + '\'' + ", size="
                + size + '}';
    }
}
