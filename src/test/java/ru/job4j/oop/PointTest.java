package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

/**
 * 1.2.1.Классы и объекты
 * 2.2.Рефакторинг-Площадь треугольника.[#122642#127051]
 * 4.Расстояние между точками в трехмерном пространстве.[#122643#127050]
 *
 * @version 2
 * @since 10.09.2021
 */
public class PointTest {
    @Test
    public void when3D001to203Then282() {
        int x1 = 0;
        int y1 = 0;
        int z1 = 1;
        int x2 = 2;
        int y2 = 0;
        int z2 = 3;
        Point a = new Point(x1, y1, z1);
        Point b = new Point(x2, y2, z2);
        double rsl = a.distance3d(b);
        assertThat(rsl, closeTo(2.82, 0.01));
    }

    @Test
    public void when3D235to532Then424() {
        int x1 = 2;
        int y1 = 3;
        int z1 = 5;
        int x2 = 5;
        int y2 = 3;
        int z2 = 2;
        Point a = new Point(x1, y1, z1);
        Point b = new Point(x2, y2, z2);
        double rsl = a.distance3d(b);
        assertThat(rsl, closeTo(4.24, 0.01));
    }

    @Test
    public void when00to20Then2Distance() {
        double expected = 2;
        int x1 = 0;
        int y1 = 0;
        int x2 = 2;
        int y2 = 0;
        Point a = new Point(x1, y1);
        Point b = new Point(x2, y2);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when13to42Then2I82Distance() {
        double expected = 3.16;
        int x1 = 1;
        int y1 = 3;
        int x2 = 4;
        int y2 = 2;
        Point a = new Point(x1, y1);
        Point b = new Point(x2, y2);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when00to50Then5Distance() {
        double expected = 5;
        int x1 = 0;
        int y1 = 0;
        int x2 = 5;
        int y2 = 0;
        Point a = new Point(x1, y1);
        Point b = new Point(x2, y2);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when13to82Then6I92Distance() {
        double expected = 7.07;
        int x1 = 1;
        int y1 = 3;
        int x2 = 8;
        int y2 = 2;
        Point a = new Point(x1, y1);
        Point b = new Point(x2, y2);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }
}