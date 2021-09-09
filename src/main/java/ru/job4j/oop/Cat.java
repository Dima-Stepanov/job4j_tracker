package ru.job4j.oop;

/**
 * 1.2.1.Классы и объекты
 * 1.5.Поля объекта[#166083#127052]
 */
public class Cat {
    private String food;
    private String name;

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void show() {
        System.out.println(this.name);
        System.out.println(this.food);
    }

    public static void main(String[] args) {
        System.out.println("There are ga's food.");
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("kotleta");
        Cat black = new Cat();
        black.giveNick("Black");
        black.eat("fish");
        gav.show();
        black.show();
    }
}
