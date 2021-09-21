package ru.job4j.search;

/**
 * 1.3.1.Коллекция List,ArrayList
 * 1.Телефонный справочник на базе ArrayList[#41598#127191]
 *
 * @since 21.09.2021
 */
public class Person {
    private String name;
    private String surname;
    private String phone;
    private String address;

    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return name + " "
                + surname + " "
                + phone + " "
                + address;
    }
}
