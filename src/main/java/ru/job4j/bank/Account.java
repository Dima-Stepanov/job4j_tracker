package ru.job4j.bank;

import java.util.Objects;

/**
 * 1.3.3.Map.HashMap.LinkedHashMap
 * 3.Банковские переводы[#10038#127210]
 * Модель банковского счета.
 * К пользователю может быть привязано несколько счетов.
 *
 * @author Dmitry
 * @version 1
 * @since 24.09.2021
 */
public class Account {
    /**
     * Номер счета
     */
    private String requisite;
    /**
     * баланс счета
     */
    private double balance;

    /**
     * Конструктор
     *
     * @param requisite Номер счета.
     * @param balance   Баланс счета.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Возвращает номер счета.
     *
     * @return String this.requisite.
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Изменяет номер счета.
     *
     * @param requisite Новое значение счета.
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Возвращает баланс счета
     *
     * @return double Balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Устанавливает новый баланс
     *
     * @param balance Account
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределение метода equals.
     *
     * @param o Object.
     * @return boolean.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределение метода hashCode.
     *
     * @return int Account hashCode requisite.
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
