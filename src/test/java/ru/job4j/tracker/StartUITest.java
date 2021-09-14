package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * 1.2.4.Полиморфизм
 * 5.Input и полиморфизм.[#181094#127031]test
 * тестируем метод createdItem StartUI
 *
 * @since 14.10.2021
 */
public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StudInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenAddItem2Element() {
        String[] answers = {"First", "Second"};
        Input input = new StudInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        StartUI.createItem(input, tracker);
        Item created0 = tracker.findAll()[0];
        Item created1 = tracker.findAll()[1];
        Item expected0 = new Item("First");
        Item expected1 = new Item("Second");
        assertThat(created0.getName(), is(expected0.getName()));
        assertThat(created1.getName(), is(expected1.getName()));
    }
}