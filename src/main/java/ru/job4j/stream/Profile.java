package ru.job4j.stream;

import java.util.Objects;

/**
 * 1.4.2.Stream API
 * 2.Список адресов[#110062#127093]
 * Модель данных Анкета клиента
 *
 * @author Dmitry
 * @version 1
 * @since 07.10.2021
 */
public class Profile {
    private String name;
    private Address address;

    public Profile(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Profile profile = (Profile) o;
        return Objects.equals(name, profile.name)
                && Objects.equals(address, profile.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }
}
