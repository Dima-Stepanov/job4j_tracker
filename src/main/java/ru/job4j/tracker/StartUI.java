package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 1.2.2.Наследование
 * 6.Date.Отображение даты.[#310017]
 * 9.toString[#310018]
 *
 * @since 12.09.2021
 */
public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        LocalDateTime itemDateTime = item.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String itemDateTimeFormat = itemDateTime.format(formatter);
        System.out.println("Data time created Item : " + itemDateTimeFormat);
        Item first = new Item("First");
        System.out.println(first);
    }
}
