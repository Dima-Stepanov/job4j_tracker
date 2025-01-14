package ru.job4j.oop;

/**
 * 1.2.1.Классы и объекты
 * 1.8. Состояние объекта [#167388 #127056]пример
 */
public class Jar {
    private int value;

    public Jar(int size) {
        this.value = size;
    }

    public int getValue() {
        return value;
    }

    public void pour(Jar another) {
        this.value = this.value + another.value;
        another.value = 0;
    }

    public static void main(String[] args) {
        Jar first = new Jar(10);
        Jar second = new Jar(5);
        System.out.println("first : "
                + first.value + ". second : "
                + second.value);
        first.pour(second);
        System.out.println("first : "
                + first.value + ". second : "
                + second.value);
    }
}
