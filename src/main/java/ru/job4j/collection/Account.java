package ru.job4j.collection;

import java.util.Objects;

/**
 * 1.3.2.Коллекция Set,HashSet
 * 3.Модели данных и HashSet.[#218530#127208]
 *
 * @since 24.09.2021
 */
public class Account {
    private String passport;
    private String username;
    private String deposit;

    public Account(String passport, String username, String deposit) {
        this.passport = passport;
        this.username = username;
        this.deposit = deposit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(passport, account.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
