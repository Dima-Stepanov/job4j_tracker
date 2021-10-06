package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 1.4.1.Lambda
 * 1.3.Встроенные функциональные интерфейсы.[#249209]
 * Поиск по модели Folder
 *
 * @author Dmitry
 * @version 1
 * @since 21.10.2021
 */
public class SearchFolder {
    /**
     * Универсальный метод поиска в списке Folder
     *
     * @param list List<Folder>
     * @param pred Predicate<Folder>
     * @return Список поиска.
     */
    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> rsl = new ArrayList<>();
        for (Folder f : list) {
            if (pred.test(f)) {
                rsl.add(f);
            }
        }
        return rsl;
    }
}
