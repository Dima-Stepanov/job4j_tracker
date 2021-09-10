package ru.job4j.inheritance;

/**
 * 1.2.2.Наследование
 * 3.Реализация профессий в коде[#6837#127062]
 */
public class Engineer extends Profession {
    private String profile;
    private String building;

    public String getName() {
        return super.getName();
    }

    public String getProfile() {
        return profile;
    }

    public String getBuilding() {
        return building;
    }
}
