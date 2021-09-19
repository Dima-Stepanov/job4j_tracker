package ru.job4j.ooa;

/**
 * 1.2.6.ООА\П
 * 4.final[#334073]
 *
 * @since 19.09.2021
 */
public final class Airbus extends Aircraft {
    private static final int COUNT_ENGINE = 2;

    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine() {
        int engine = COUNT_ENGINE;
        if (name.equals("A380")) {
            engine = 4;
        }
        System.out.println("Количестов двиготелей равно: " + engine);
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}
