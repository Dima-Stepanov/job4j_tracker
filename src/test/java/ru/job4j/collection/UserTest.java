package ru.job4j.collection;

import org.junit.Test;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 1.3.4.Сортировка
 * 1.Организовать сортировку User[#10034#127201]test
 *
 * @since 27.09.2021
 */
public class UserTest {
    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }

    @Test
    public void whenUserNameEquals() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 33));
        users.add(new User("Petr", 35));
        users.add(new User("Petr", 31));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Petr", 31)));
        assertThat(it.next(), is(new User("Petr", 33)));
        assertThat(it.next(), is(new User("Petr", 35)));
    }

    @Test
    public void whenCompareNameEqualsPetr33VSPetr31() {
        int rsl = new User("Petr", 33).compareTo(new User("Petr", 31));
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparePertVSIvan() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 32)
                );
        assertThat(rsl, greaterThan(0));
    }
}