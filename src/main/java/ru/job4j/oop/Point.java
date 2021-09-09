package ru.job4j.oop;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

/**
 * 1.2.1.Классы и объекты
 * 2.2.Рефакторинг-Площадь треугольника.[#122642#127051]
 */
public class Point {
    private int x;
    private int y;

    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public double distance(Point that) {
        return sqrt(pow(this.x - that.x, 2)
                + pow(this.y - that.y, 2));
    }
}
