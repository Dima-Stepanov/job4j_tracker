package ru.job4j.poly;

/**
 * 1.2.4.Полиморфизм
 * 3.2.Зачем нужно приведение типов[#310019]
 * Автобус
 *
 * @since 14.10.2021
 */
public class Autobus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Автобус двигается по скоростным трассам.");
    }

    @Override
    public void ges() {
        System.out.println("Автобус заправляют дизельным топливом.");
    }

    @Override
    public void speed() {
        System.out.println("Автобус двигается со скоростью 80 км/ч.");
    }
}
