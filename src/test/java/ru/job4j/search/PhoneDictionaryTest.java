package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 1.3.1.Коллекция List,ArrayList
 * 1.Телефонный справочник на базе ArrayList[#41598#127191]test
 *
 * @since 21.09.2021
 */
public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(new Person("Petr", "Arsentev",
                "534872", "Bryansk"));
        ArrayList<Person> person = phoneDictionary.find("Petr");
        assertThat(person.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindByPhone2Address() {
        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(new Person("Petr", "Arsentev",
                "8900", "Bryansk"));
        phoneDictionary.add(new Person("Dima", "Krasin",
                "8900", "Krsnodar"));
        ArrayList<Person> person = phoneDictionary.find("8900");
        assertThat(person.get(0).getSurname(), is("Arsentev"));
        assertThat(person.get(1).getSurname(), is("Krasin"));
    }
}