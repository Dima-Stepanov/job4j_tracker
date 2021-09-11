package ru.job4j.pojo;

import java.util.Date;

/**
 * 1.2.3.Инкапсуляция
 * 2.Модель данных.[#174683#127064]
 *
 * @since 11.09.2021
 */
public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Dmitry Krasin");
        student.setGroup("IT 2B");
        student.setIncome(new Date());
        System.out.println("FIO student : " + student.getFio()
                + System.lineSeparator()
                + "Group : " + student.getGroup()
                + System.lineSeparator()
                + "Date : " + student.getIncome());
    }
}
