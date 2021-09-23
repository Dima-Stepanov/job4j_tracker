package ru.job4j.collection;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * 1.3.2.Коллекция Set,HashSet
 * 2.Идентичные тексты[#212655#127206]test
 *
 * @since 23.09.2021
 */
public class UniqueTextTest {

    @Test
    public void isEquals() {
        String origin = "My cat eats a mouse and milk";
        String text = "My cat eats milk and a mouse";
        assertTrue(UniqueText.isEquals(origin, text));
    }

    @Test
    public void isNotEquals() {
        String origin = "My cat eats a mouse";
        String text = "A mouse eats a cat";
        assertFalse(UniqueText.isEquals(origin, text));

    }
}