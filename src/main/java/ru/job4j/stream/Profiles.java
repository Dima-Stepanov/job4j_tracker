package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1.4.2.Stream API.
 * 2.Список адресов[#110062#127093].
 * 3.Уникальность элементов и сортировка.[#110225#127092]
 * сортируем по городу, убираем одинаковые адреса.
 *
 * @author Dmitry
 * @version 1
 * @since 07.10.2021
 */
public class Profiles {
    /**
     * Выборка адресов клиентов.
     *
     * @param profiles список клиентов с адресами.
     * @return список адресов.
     */
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .distinct()
                .sorted(Comparator.comparing(Address::getCity))
                .collect(Collectors.toList());
    }
}
