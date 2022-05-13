package ru.job4j.tracker.model;

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
public class Item implements Comparable<Item> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private String description;
    private LocalDateTime created = LocalDateTime.now().withNano(0);
    @Transient
    private final DateTimeFormatter
            timeFormatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Item of(String name, String description) {
        Item item = new Item();
        item.name = name;
        item.description = description;
        return item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateTimeFormatter getTimeFormatter() {
        return timeFormatter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return id == item.id
                && Objects.equals(name, item.name)
                && Objects.equals(created, item.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return String.format("id: %s, name: %s, created: %s",
                id, name, timeFormatter.format(created));
    }

    @Override
    public int compareTo(Item another) {
        return Integer.compare(id, another.id);
    }
}