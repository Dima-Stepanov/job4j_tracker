package ru.job4j.poly;

/**
 * 1.2.4.Полиморфизм
 * 3.2.Зачем нужно приведение типов[#310019]
 * Самалет
 *
 * @since 14.10.2021
 */
public class Aircraft implements Vehicle {
    @Override
    public void move() {
        System.out.println("Самолет летает по воздуху.");
    }

    @Override
    public void ges() {
        System.out.println("Самолет запровляют керасином.");
    }

    @Override
    public void speed() {
        System.out.println("Самолет летает со скоростью 600 км/ч.");
    }
}
