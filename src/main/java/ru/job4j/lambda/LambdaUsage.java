package ru.job4j.lambda;

import java.util.Comparator;

/**
 * 1.4.1.Lambda
 * 2.2.Лямбда блок[#249208]
 *
 * @author Dmitry
 * @version 1
 * @since 06.10.2021
 */
public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> cmpText = (left, right) -> {
            System.out.println("compare - " + left + " : " + right);
            return left.compareTo(right);
        };
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + left.length() + " : " + right.length());
            return Integer.compare(right.length(), left.length());
        };
    }
}
