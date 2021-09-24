package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;

/**
 * 1.3.3.Map.HashMap.LinkedHashMap
 * 2.Преобразования List в Map.[#10093#127211]
 *
 * @since 24.09.2021
 */
public class OrderConvert {
    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map = new HashMap<>();
        for (Order order : orders) {
            map.put(order.getNumber(), order);
        }
        return map;
    }
}
