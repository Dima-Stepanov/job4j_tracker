package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * 1.4.1.Lambda
 * 5.Подсчет функции в диапазоне.[#24251#127079]
 *
 * @author Dima_Nout
 * @version 1
 * @since 06.10.2021
 */
public class FunctionDiapason {
    /**
     * Метод считает функции в диапозоне.
     *
     * @param start начало диапозона.
     * @param end   конец диапозона(не входит в диапозон).
     * @param func  функция.
     * @return Список функций.
     */
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>();
        for (int i = start; i < end; i++) {
            rsl.add(func.apply((double) i));
        }
        return rsl;
    }
}
