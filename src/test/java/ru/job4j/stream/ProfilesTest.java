package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * 1.4.2.Stream API
 * 2.Список адресов[#110062#127093]test
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
}