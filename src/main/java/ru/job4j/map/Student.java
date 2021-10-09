package ru.job4j.map;

import java.util.Objects;

/**
 * 1.4.2. Stream API
 * 6.Тестовое задание из модуля коллекции
 * Lite переделать на Stream API.[#24260#127094]
 * Пример.
 * Модель данных.Student - модель описывает студента,
 * в нем определены 3 поля:
 * имя студента, аккаунт (уникальный идентификатор), группа.
 *
 * @author Dima_Nout
 * @version 1
 * @since 10.10.2021
 */
public class Student {
    private String name;
    private String account;
    private String group;

    public Student(String name, String account, String group) {
        this.name = name;
        this.account = account;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public Student setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getGroup() {
        return group;
    }

    public Student setGroup(String group) {
        this.group = group;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(account, student.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account);
    }

    @Override
    public String toString() {
        return "Student{"
                + "name='" + name + '\''
                + ", account='" + account + '\''
                + ", group='" + group + '\''
                + '}';
    }
}
