package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * 1.2.4.Полиморфизм
 * 5.Input и полиморфизм.[#181094#127031]test
 * тестируем метод createdItem StartUI
 * 5.1.Тестирование.Подготовка данных.[#182960#127022]
 * 8.Реализация меню за счет шаблона стратегия.[#181780#127032]
 * 9.Написать тесты на StartUI.[#785#127017]
 * 9.1.Зависимость от System.out[#33568#127018]
 *
 * @since 16.09.2021
 */
public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StudInput(answers);
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        CreateAction createAction = new CreateAction(output);
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
        Output output = new ConsoleOutput();
        CreateAction createAction = new CreateAction(output);
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
        Output out = new ConsoleOutput();
        ReplaceAction replaceAction = new ReplaceAction(out);
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
        Output output = new ConsoleOutput();
        DeleteAction deleteAction = new DeleteAction(output);
        deleteAction.execute(input, tracker);
        Assert.assertNull(tracker.findById(idItem));
    }

    @Test
    public void whenInitCreateItem() {
        Input input = new StudInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction(output)
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenInitReplaceItem() {
        Input input = new StudInput(
                new String[]{"0", "1", "Replace Item", "1"}
        );
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitAction(output)
        };
        Item item = new Item("Item");
        tracker.add(item);
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is("Replace Item"));
    }

    @Test
    public void whenInitDeleteItem() {
        Input input = new StudInput(new String[]{"0", "1", "1"});
        Output output = new ConsoleOutput();
        UserAction[] action = {
                new DeleteAction(output),
                new ExitAction(output)
        };
        Tracker tracker = new Tracker();
        Item item = new Item("Item");
        tracker.add(item);
        new StartUI().init(input, tracker, action);
        Assert.assertNull(tracker.findById(item.getId()));
    }
}