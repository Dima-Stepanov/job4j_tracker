package ru.job4j.oop;

/**
 * 1.2.1. Классы и объекты
 * 1.9. Статические и не статические методы [#504806]
 *
 * @author Dmitry
 * @version 1
 * @since 18.11.2021
 */
public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int y) {
        return x * y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("X=5; Y=10");
        System.out.println("Sum x+y: " + sum(10));
        System.out.println("Multiply x+y: " + calculator.multiply(10));
        System.out.println("Minus y-x: " + minus(10));
        System.out.println("Divide y/x: " + calculator.divide(10));
        System.out.println("Sum All Operation: " + calculator.sumAllOperation(10));
    }
}
