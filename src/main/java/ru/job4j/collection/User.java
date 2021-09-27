package ru.job4j.collection;

import java.util.Objects;

/**
 * 1.3.4.Сортировка
 * 1.Организовать сортировку User[#10034#127201]
 *
 * @since 27.09.2021
 */
public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(User another) {
        int rsl = name.compareTo(another.name);
        return rsl == 0 ? Integer.compare(age, another.age) : rsl;
    }
}
