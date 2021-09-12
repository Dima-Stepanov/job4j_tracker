package ru.job4j.poly;

/**
 * 1.2.4.Полиморфизм
 * 3.Интерфейс Input[#181092#127027]
 *
 * @since 13.10.2021
 */
public interface Transport {

    void drive();

    void passenger(int numb);

    double tankUp(double fuel);
}
