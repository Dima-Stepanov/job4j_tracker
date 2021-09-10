package ru.job4j.inheritance;

/**
 * 1.2.2.Наследование
 * 3.Реализация профессий в коде[#6837#127062]
 */
public class Taecher extends Profession {
    private String school;
    private String lesson;

    @Override
    public String getName() {
        return super.getName();
    }

    public String getSchool() {
        return school;
    }

    public String getLesson() {
        return lesson;
    }

    public String pupil(Pupil pupil) {
        return pupil.getName();
    }
}
