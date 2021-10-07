package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

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
        Predicate<Person> combine = p ->
                p.getName().equals(key) || p.getSurname().equals(key)
                        || p.getPhone().equals(key) || p.getAddress().equals(key);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
