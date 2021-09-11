package ru.job4j.pojo;

/**
 * 1.2.3.Инкапсуляция
 * 3.1.Массив с пустыми ячейками[#176470#127072]
 * модель данных
 *
 * @since 11.10.2021
 */
public class Product {
    private String name;
    private int count;

    public Product(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
