package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 1.2.1.Классы и объекты
 * 2.2.Рефакторинг-Площадь треугольника.[#122642#127051]test
 */
public class TriangleTest {

    @Test
    public void area() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(8, 0.001));
    }
}