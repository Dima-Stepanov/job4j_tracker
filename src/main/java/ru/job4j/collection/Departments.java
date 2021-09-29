package ru.job4j.collection;

import java.util.*;

/**
 * 1.3.6.Контрольные вопросы.
 * 2.Отсортировать департаменты.
 *
 * @author Dmitry
 * @version 1
 * @since 29.09.2021
 */
public class Departments {
    /**
     * Добавляет в список департамента недостающие элементы.
     *
     * @param deps Входной список подразделений.
     * @return полный список подразделение с добавлением недостающих.
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if (!start.equals("")) {
                    start = start + "/" + el;
                    tmp.add(start);
                } else {
                    start = el;
                    tmp.add(start);
                }
            }
        }
        return new ArrayList<>(tmp);
    }

    /**
     * Сортировка департамента по возрастанию Comparator.naturalOrder.
     * @param orgs неотсортированный список.
     */
    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    /**
     * Сортировка департамента по убыванию.
     * @param orgs неотсортированный список.
     */
    public static void sortDesc(List<String> orgs) {

    }
}
