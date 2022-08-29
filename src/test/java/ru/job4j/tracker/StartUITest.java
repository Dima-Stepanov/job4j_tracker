package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StudInput;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StudOutput;
import ru.job4j.tracker.store.MemTracker;

import java.util.List;

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
 * 9.2.Тесты вывода на консоль[#33585#127016]
 * 1.2.5.Исключения
 * 1.1.Тесты на StartUI.[#223313#127036]
 *
 * @since 16.09.2021
 */
public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StudInput(answers);
        MemTracker memTracker = new MemTracker();
        Output output = new ConsoleOutput();
        CreateAction createAction = new CreateAction(output);
        createAction.execute(input, memTracker);
        Item created = memTracker.findAll().get(0);
        Item expected = new Item();
        expected.setName("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenAddItem2Element() {
        String[] answers = {"First", "Second"};
        Input input = new StudInput(answers);
        MemTracker memTracker = new MemTracker();
        Output output = new ConsoleOutput();
        CreateAction createAction = new CreateAction(output);
        createAction.execute(input, memTracker);
        createAction.execute(input, memTracker);
        Item created0 = memTracker.findAll().get(0);
        Item created1 = memTracker.findAll().get(1);
        Item expected0 = new Item();
        expected0.setName("First");
        Item expected1 = new Item();
        expected1.setName("Second");
        assertThat(created0.getName(), is(expected0.getName()));
        assertThat(created1.getName(), is(expected1.getName()));
    }

    @Test
    public void whenReplaceItem() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item();
        item.setName("new item");
        memTracker.add(item);
        String[] answer = {
                String.valueOf(item.getId()),
                "replace item"
        };
        Input input = new StudInput(answer);
        Output out = new ConsoleOutput();
        ReplaceAction replaceAction = new ReplaceAction(out);
        replaceAction.execute(input, memTracker);
        Item replaced = memTracker.findById(item.getId());
        assertThat(replaced.getName(), is("replace item"));
    }

    @Test
    public void whenDeleteItem() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item();
        item.setName("delete item");
        memTracker.add(item);
        int idItem = item.getId();
        String[] answer = {String.valueOf(idItem)};
        Input input = new StudInput(answer);
        Output output = new ConsoleOutput();
        DeleteAction deleteAction = new DeleteAction(output);
        deleteAction.execute(input, memTracker);
        Assert.assertNull(memTracker.findById(idItem));
    }

    @Test
    public void whenInitCreateItem() {
        Input input = new StudInput(
                new String[]{"0", "Item name", "1"}
        );
        MemTracker memTracker = new MemTracker();
        Output output = new ConsoleOutput();
        List<UserAction> actions = List.of(
                new CreateAction(output),
                new ExitAction()
        );
        new StartUI(output).init(input, memTracker, actions);
        assertThat(memTracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenInitReplaceItem() {
        Input input = new StudInput(
                new String[]{"0", "1", "Replace Item", "1"}
        );
        MemTracker memTracker = new MemTracker();
        Output output = new ConsoleOutput();
        List<UserAction> actions = List.of(
                new ReplaceAction(output),
                new ExitAction()
        );
        Item item = new Item();
        item.setName("Item");
        memTracker.add(item);
        new StartUI(output).init(input, memTracker, actions);
        assertThat(memTracker.findById(item.getId()).getName(), is("Replace Item"));
    }

    @Test
    public void whenInitDeleteItem() {
        Input input = new StudInput(new String[]{"0", "1", "1"});
        Output output = new ConsoleOutput();
        List<UserAction> action = List.of(
                new DeleteAction(output),
                new ExitAction()
        );
        MemTracker memTracker = new MemTracker();
        Item item = new Item();
        item.setName("Item");
        memTracker.add(item);
        new StartUI(output).init(input, memTracker, action);
        Assert.assertNull(memTracker.findById(item.getId()));
    }

    @Test
    public void whenOutExit() {
        Output out = new StudOutput();
        Input input = new StudInput(
                new String[]{"0"}
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = List.of(new ExitAction());
        new StartUI(out).init(input, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenOutFindAllAction() {
        Output out = new StudOutput();
        Input in = new StudInput(
                new String[]{"0", "1"}
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = List.of(
                new FindAllAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Show all items ===" + System.lineSeparator()
                        + "Хранилище еще не содержит заявок" + System.lineSeparator()
                        + "Menu:" + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenOutFindByNameAction() {
        Output out = new StudOutput();
        Input input = new StudInput(
                new String[]{"0", "Item", "1"}
        );
        List<UserAction> action = List.of(
                new FindByNameAction(out),
                new ExitAction()
        );
        MemTracker memTracker = new MemTracker();
        new StartUI(out).init(input, memTracker, action);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Find Item by NAME ===" + System.lineSeparator()
                        + "Заявки с именем: Item не найдены." + System.lineSeparator()
                        + "Menu:" + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenOutFindByIDAction() {
        Output out = new StudOutput();
        Input input = new StudInput(
                new String[]{"0", "11", "1"}
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> action = List.of(
                new FindByIDAction(out),
                new ExitAction()
        );
        new StartUI(out).init(input, memTracker, action);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Find Item by ID ===" + System.lineSeparator()
                        + "Заявка с введенным id: 11 не найдена." + System.lineSeparator()
                        + "Menu:" + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StudOutput();
        Input in = new StudInput(new String[]{"9", "0"});
        List<UserAction> actions = List.of(
                new ExitAction()
        );
        MemTracker memTracker = new MemTracker();
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0.. 0" + ln
                        + "Menu:" + ln
                        + "0. Exit Program" + ln
        ));
    }
}