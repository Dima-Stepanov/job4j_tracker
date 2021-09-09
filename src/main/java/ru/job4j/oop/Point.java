package ru.job4j.oop;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

/**
 * 1.2.1.Классы и объекты
 * 2.2.Рефакторинг-Площадь треугольника.[#122642#127051]
 * 4.Расстояние между точками в трехмерном пространстве.[#122643#127050]
 *
 * @version 2
 * @since 10.09.2021
 */
public class Point {
    private int x;
    private int y;
    private int z;

    /**
     * Конструктор, который принимает начальное состояние объекта "точка"
     *
     * @param first  координата x
     * @param second координата y
     */
    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    /**
     * Конструктор, который принимает начальное состояние объекта "точка"
     *
     * @param first  координата x
     * @param second координата y
     * @param third  координаты z
     */
    public Point(int first, int second, int third) {
        this.x = first;
        this.y = second;
        this.z = third;
    }

    /**
     * Растояние между точками a, b вдумерные координаты
     *
     * @param that Point
     * @return distance a, b
     */
    public double distance(Point that) {
        return sqrt(pow(this.x - that.x, 2)
                + pow(this.y - that.y, 2));
    }

    /**
     * Расстояние между точками a,b в 3D пространстве
     *
     * @param that Point
     * @return distance 3D
     */
    public double distance3d(Point that) {
        return sqrt(pow(this.x - that.x, 2)
                + pow(this.y - that.y, 2)
                + pow(this.z - that.z, 2));
    }

    /**
     * Инфо о координатах
     */
    public void info() {
        System.out.println("Point[" + this.x + ", "
                + this.y + ", "
                + this.z + "]");
    }
}
