package ru.job4j.search;

import java.util.ArrayList;

/**
 * 1.3.1.Коллекция List,ArrayList
 * 1.Телефонный справочник на базе ArrayList[#41598#127191]
 *
 * @since 21.09.2021
 */
public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, которые содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.toString().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}
