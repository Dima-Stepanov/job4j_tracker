package ru.job4j.function;

import java.util.Objects;

/**
 * 1.4.1.Lambda
 * 1.3.Встроенные функциональные интерфейсы.[#249209]
 * Модель данных.
 *
 * @author Dmitry
 * @version 1
 * @since 21.10.2021
 */
public class Folder {
    private String name;
    private int size;

    /**
     * Конструктор.
     *
     * @param name This.name String.
     * @param size This.size int.
     */
    public Folder(String name, int size) {
        this.name = name;
        this.size = size;
    }

    /**
     * Get name.
     *
     * @return String name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get size.
     *
     * @return int size.
     */
    public int getSize() {
        return size;
    }

    /**
     * Equals.
     *
     * @param o Folder name size.
     * @return true false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Folder folder = (Folder) o;
        return size == folder.size && Objects.equals(name, folder.name);
    }

    /**
     * HashCode.
     *
     * @return hashCode name && size.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }
}
