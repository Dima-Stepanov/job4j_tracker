package ru.job4j.poly;

/**
 * 1.2.4.Полиморфизм
 * 3.Интерфейс Input[#181092#127027]
 *
 * @since 13.10.2021
 */
public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("go go go");
    }

    @Override
    public void passenger(int numb) {
        System.out.println("Passenger on Bus: " + numb);
    }

    @Override
    public double tankUp(double fuel) {
        return fuel * 99.99D;
    }
}
