package ru.job4j.poly;

/**
 * 1.2.4.Полиморфизм
 * 3.2.Зачем нужно приведение типов[#310019]
 * Поезд
 *
 * @since 14.10.2021
 */
public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Поезд передвигается по рельсам.");
    }

    @Override
    public void ges() {
        System.out.println("Поезд двигается на электроэнергии.");
    }

    @Override
    public void speed() {
        System.out.println("Поезд передвигается со скоростью 250 км/ч.");
    }
}
