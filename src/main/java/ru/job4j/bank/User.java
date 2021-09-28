package ru.job4j.bank;

import java.util.Objects;

/**
 * 1.3.3.Map.HashMap.LinkedHashMap
 * 3.Банковские переводы[#10038#127210]
 * Модель данных пользователя банка.
 *
 * @author Dmitry
 * @version 1
 * @since 24.09.2021
 */
public class User {
    /**
     * Номер паспорта клиента банка.
     */
    private String passport;
    /**
     * ФИО клиента банка
     */
    private String username;

    /**
     * Конструктор создания объекта User.
     *
     * @param passport Номер паспорта нового клиента.
     * @param username ФИО нового клиента банка.
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Возвращает номер паспорта пользователя.
     *
     * @return User passport
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Изменяет номер паспорта клиента банка.
     *
     * @param passport new number User passport
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Возвращает ФИО клиента банка.
     *
     * @return username User
     */
    public String getUsername() {
        return username;
    }

    /**
     * Изменяет ФИО клиента банка.
     *
     * @param username Новое имя пользователя.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределение метода equals.
     *
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределение метода hashCode.
     *
     * @return int User hashCode passport.
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
