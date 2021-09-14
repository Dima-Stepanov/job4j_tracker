package ru.job4j.poly;

/**
 * 1.2.4.Полиморфизм
 * 3.2.Зачем нужно приведение типов[#310019]
 * main
 *
 * @since 14.10.2021
 */
public class Trans {
    public static void main(String[] args) {
        Vehicle aircraft = new Aircraft();
        Vehicle train = new Train();
        Vehicle autobus = new Autobus();
        Vehicle[] vehicles = new Vehicle[]{aircraft, train, autobus};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.speed();
            vehicle.ges();
        }
    }
}
