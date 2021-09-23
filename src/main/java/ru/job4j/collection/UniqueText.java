package ru.job4j.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * 1.3.2.Коллекция Set,HashSet
 * 2.Идентичные тексты[#212655#127206]
 *
 * @since 23.09.2021
 */
public class UniqueText {
    public static boolean isEquals(String originText, String duplixText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplixText.split(" ");
        Set<String> check = new HashSet<>();
        for (String lang : origin) {
            check.add(lang);
        }
        for (String lang : text) {
            if (!check.contains(lang)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
