package ru.job4j.oop;

import static java.lang.Math.sqrt;

/**
 * 1.2.1.Классы и объекты
 * 2.2.Рефакторинг-Площадь треугольника.[#122642#127051]
 */
public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    /**
     * Расчет полупериметра треугольника
     *
     * @param a side
     * @param b side
     * @param c side
     * @return perimeter:2
     */
    public double semiPerimeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    /**
     * проверяет возможно ли из сторон с длинами a, b и c
     * построить треугольник
     *
     * @param ab side
     * @param ac side
     * @param bc side
     * @return true false
     */
    public boolean exist(double ab, double ac, double bc) {
        return ab + ac > bc && ac + bc > ab && ab + bc > ac;
    }

    /**
     * рассчитывает площадь треугольника согласно формуле Герона
     *
     * @return double area
     */
    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        if (exist(ab, ac, bc)) {
            double p = semiPerimeter(ab, ac, bc);
            rsl = sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }
}
