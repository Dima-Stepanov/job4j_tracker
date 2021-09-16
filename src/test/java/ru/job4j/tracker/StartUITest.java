package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * 1.2.4.Полиморфизм
 * 5.Input и полиморфизм.[#181094#127031]test
 * тестируем метод createdItem StartUI
 * 5.1.Тестирование.Подготовка данных.[#182960#127022]
 * 8.Реализация меню за счет шаблона стратегия.[#181780#127032]
 *
 * @since 16.10.2021
 */
public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StudInput(answers);
        Tracker tracker = new Tracker();
        CreateAction createAction = new CreateAction();
        createAction.execute(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenAddItem2Element() {
        String[] answers = {"First", "Second"};
        Input input = new StudInput(answers);
        Tracker tracker = new Tracker();
        CreateAction createAction = new CreateAction();
        createAction.execute(input, tracker);
        createAction.execute(input, tracker);
        Item created0 = tracker.findAll()[0];
        Item created1 = tracker.findAll()[1];
        Item expected0 = new Item("First");
        Item expected1 = new Item("Second");
        assertThat(created0.getName(), is(expected0.getName()));
        assertThat(created1.getName(), is(expected1.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answer = {
                String.valueOf(item.getId()),
                "replace item"
        };
        Input input = new StudInput(answer);
        ReplaceAction replaceAction = new ReplaceAction();
        replaceAction.execute(input, tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replace item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("delete ietm");
        tracker.add(item);
        int idItem = item.getId();
        String[] answer = {String.valueOf(idItem)};
        Input input = new StudInput(answer);
        DeleteAction deleteAction = new DeleteAction();
        deleteAction.execute(input, tracker);
        Assert.assertNull(tracker.findById(idItem));
    }
}