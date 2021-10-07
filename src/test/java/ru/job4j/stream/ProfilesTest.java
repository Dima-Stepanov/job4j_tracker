package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * 1.4.2.Stream API
 * 2.Список адресов[#110062#127093]test
 * 3.Уникальность элементов и сортировка.[#110225#127092]test
 *
 * @author Dmitry
 * @version 1
 * @since 07.10.2021
 */
public class ProfilesTest {

    @Test
    public void whenProfilesThenListAddress() {
        List<Profile> profiles = List.of(
                new Profile("FIO1",
                        new Address("Krd", "Krasn", 23, 123)),
                new Profile("FIO2",
                        new Address("Rostov", "Doloman", 11, 159))
        );
        List<Address> expected = List.of(
                new Address("Krd", "Krasn", 23, 123),
                new Address("Rostov", "Doloman", 11, 159)
        );
        List<Address> rsl = new Profiles().collect(profiles);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenProfilesThenListAddressSortByCitiAndDistinctAdress() {
        List<Profile> profiles = List.of(
                new Profile("FIO3",
                        new Address("Rostov-on-Don", "Doloman", 11, 159)),
                new Profile("FIO1",
                        new Address("Krasnodar", "Krasn", 23, 123)),
                new Profile("FIO2",
                        new Address("Rostov-on-Don", "Doloman", 11, 159)),
                new Profile("FIO4",
                        new Address("Krasnodar", "Krasn", 23, 123))
        );
        List<Address> expected = List.of(
                new Address("Krasnodar", "Krasn", 23, 123),
                new Address("Rostov-on-Don", "Doloman", 11, 159)
        );
        List<Address> rsl = new Profiles().collect(profiles);
        assertThat(rsl, is(expected));
    }
}