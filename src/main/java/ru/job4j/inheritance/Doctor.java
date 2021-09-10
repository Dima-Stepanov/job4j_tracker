package ru.job4j.inheritance;

/**
 * 1.2.2.Наследование
 * 3.Реализация профессий в коде[#6837#127062]
 */
public class Doctor extends Profession {
    private String profile;
    private String ambulance;

    public String getName() {
        return super.getName();
    }

    public String getProfile() {
        return profile;
    }

    private String getAmbulance() {
        return ambulance;
    }

    public Diagnosis heal(Pacient pacient) {
        return pacient.getDiagnosis();
    }
}
