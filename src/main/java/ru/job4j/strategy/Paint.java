package ru.job4j.strategy;

/**
 * 1.2.4.Полиморфизм
 * 7.Шаблон проектирования-Стратегия[#786#127021]
 *
 * @since 15.10.2021
 */
public class Paint {
    public void draw(Shape shape) {
        System.out.print(shape.draw());
    }

    public static void main(String[] args) {
        Paint context = new Paint();
        context.draw(new Triangle());
        context.draw(new Square());
    }

}
