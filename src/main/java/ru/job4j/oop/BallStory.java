package ru.job4j.oop;

/**
 * 1.2.1.Классы и объекты
 * 1.6.Взаимодействие объектов[#166087#127045]
 */
public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        hare.tryEat(ball);
        ball.goGo(hare);
        wolf.tryEat(ball);
        ball.goGo(wolf);
        fox.tryEat(ball);
    }
}
