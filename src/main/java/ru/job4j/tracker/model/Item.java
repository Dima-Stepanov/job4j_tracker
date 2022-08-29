package ru.job4j.tracker.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * 1.2.2.Наследование
 * 2.Перегрузка конструктора[#173890#127063]
 * 6.Date.Отображение даты.[#310017]
 * 9.toString[#310018]
 *
 * @since 12.09.2021
 */
@Entity
@Table(name = "items")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Item implements Comparable<Item> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    @EqualsAndHashCode.Include
    private int id;
    @Column(name = "item_name")
    @EqualsAndHashCode.Include
    private String name;
    private String description;
    private LocalDateTime created = LocalDateTime.now().withNano(0);
    @Transient
    private final DateTimeFormatter
            timeFormatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    @Override
    public int compareTo(Item another) {
        return Integer.compare(id, another.id);
    }
}