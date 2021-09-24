package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

/**
 * 1.3.2.Коллекция Set,HashSet
 * 3.Модели данных и HashSet.[#218530#127208]
 *
 * @since 24.09.2021
 */
public class NotifyAccount {
    public static HashSet<Account> sent(List<Account> accounts) {
        HashSet<Account> rsl = new HashSet<>();
        for (Account account : accounts) {
            rsl.add(account);
        }
        return rsl;
    }
}
