package ru.job4j.pojo;

import java.util.Date;

/**
 * 1.2.3.Инкапсуляция
 * 2.Модель данных.[#174683#127064]пример
 *
 * @since 11.09.2021
 */
public class Police {
    public static void main(String[] args) {
        License license = new License("Petr Arsentev", "Vaz", "x123ep", new Date());
        System.out.println(license.getOwner()
                + " has a car - " + license.getModel()
                + " : " + license.getCode()
                + " Date " + license.getCreated());
    }
}
