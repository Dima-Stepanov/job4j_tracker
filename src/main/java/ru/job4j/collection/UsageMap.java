package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.3.3.Map.HashMap.LinkedHashMap
 * 0.Map,HashMap[#212652#127212]
 *
 * @since 24.09.2021
 */
public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("haoos@mail.ru", "Dmitry");
        map.put("mail@mail.ru", "Petr");
        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }
}
