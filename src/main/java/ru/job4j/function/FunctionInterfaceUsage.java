package ru.job4j.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;

/**
 * 1.4.1.Lambda
 * 1.2.Функциональный интерфейc[#247497]
 *
 * @author Dmitry
 * @version 1
 * @since 04.10.2021
 */
public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        Supplier<String> sup = () -> "New String For Interface";
        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept(sup.get());
        BiConsumer<String, String> biConsumer = (s, s1) -> System.out.println(s + s1);
        biConsumer.accept(sup.get(), " and Second String");
        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> sup1 = () -> new HashSet<>(list);
        BiConsumer<Integer, String> biConsumer1 = (s, s1) -> System.out.println(s + s1);
        Set<String> strings = sup1.get();
        int p = 1;
        for (String s : strings) {
            biConsumer1.accept(p++, " is " + s);
        }

        Predicate<String> pred = (s) -> s.isEmpty();
        System.out.println("Строка пустая: " + pred.test(""));
        System.out.println("Строка пустая: " + pred.test("test"));
        BiPredicate<String, Integer> cond = (s, i) -> s.contains(i.toString());
        System.out.println("Строка содержит подстроку: " + cond.test("Name123", 123));
        System.out.println("Строка содержит подстроку: " + cond.test("Name", 123));
    }
}
