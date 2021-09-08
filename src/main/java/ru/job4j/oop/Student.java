package ru.job4j.oop;

/**
 * 1.2.1.Классы и объекты
 * 1.2.Вызов метода объекта[#166085#127057]
 */
public class Student {
    public void music() {
        System.out.println("Tra tra tra");
    }

    public void song() {
        System.out.println("I believe I can fly");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        petya.music();
        petya.song();
        petya.music();
        petya.song();
        petya.music();
        petya.song();
    }
}
