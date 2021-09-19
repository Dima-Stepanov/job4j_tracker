package ru.job4j.ooa;

/**
 * 1.2.6.ООА\П
 * 4.final[#334073]
 *
 * @since 19.09.2021
 */
public class Airport {
    public static void main(String[] args) {
        final Airbus airbus = new Airbus("A320");
        System.out.println(airbus);
        airbus.printModel();
        airbus.printCountEngine();

        airbus.setName("A380");
        System.out.println(airbus);
        airbus.printModel();
        airbus.printCountEngine();
    }
}
