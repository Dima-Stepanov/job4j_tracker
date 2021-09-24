package ru.job4j.collection;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * 1.3.3.Map.HashMap.LinkedHashMap
 * 1.Паспорт и жители[#212656#127213]test
 *
 * @since 24.09.2021
 */
public class PassportOfficeTest {

    @Test
    public void addTrue() {
        Citizen citizen = new Citizen("2ff44a", "Petr");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void addFalse() {
        Citizen citizen = new Citizen("2ff44a", "Petr");
        Citizen citizen1 = new Citizen("2ff44a", "Dmity");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertFalse(office.add(citizen1));
    }
}