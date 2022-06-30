package ru.job4j.stream.counting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Упражнения JavaCore
 * 1.4.2. Stream API
 * 2.2. Группировка элементов и подсчет количества.
 * Метод counting()
 * Клас реализации метода counting
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 30.06.2022
 */
public class CountingMethod {
    public Map<String, Long> groupAndCount(List<Worker> workers) {
        return workers.stream()
                .collect(Collectors.groupingBy(
                        worker -> worker.getCompany().getName(),
                        Collectors.counting()
                ));
    }
}
