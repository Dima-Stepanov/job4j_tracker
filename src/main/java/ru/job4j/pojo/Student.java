package ru.job4j.pojo;

import java.util.Date;

/**
 * 1.2.3.Инкапсуляция
 * 2.Модель данных.[#174683#127064]
 *
 * @since 11.09.2021
 */
public class Student {
    private String fio;
    private String group;
    private Date income;

    public String getFio() {
        return fio;
    }

    public Student setFio(String fio) {
        this.fio = fio;
        return this;
    }

    public String getGroup() {
        return group;
    }

    public Student setGroup(String group) {
        this.group = group;
        return this;
    }

    public Date getIncome() {
        return income;
    }

    public Student setIncome(Date income) {
        this.income = income;
        return this;
    }
}
