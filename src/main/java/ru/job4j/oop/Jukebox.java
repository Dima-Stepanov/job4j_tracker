package ru.job4j.oop;

/**
 * 1.2.1.Классы и объекты
 * 1.3.Вызов метода с аргументами.[#166086#127046]
 */
public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox sound = new Jukebox();
        int first = 1;
        int second = 2;
        int third = 4;
        sound.music(first);
        sound.music(second);
        sound.music(third);
    }
}
