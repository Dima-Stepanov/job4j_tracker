package ru.job4j.tracker.action;

import org.junit.Test;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StudOutput;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 3. Мидл
 * 3.2.1. Web
 * 3.2.8. Spring Test, Mockito
 * 1. Что такое Mock-объект. [#504866]
 * DeleteActionTest. Mockito.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 12.04.2022
 */
public class DeleteActionTest {
    @Test
    public void whenDeleteActionMockitoThenOk() {
        Output output = new StudOutput();
        MemTracker tracker = new MemTracker();
        Item item1 = new Item();
        item1.setName("item1");
        Item item2 = new Item();
        item1.setName("item2");
        tracker.add(item1);
        tracker.add(item2);
        DeleteAction deleteAction = new DeleteAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        deleteAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is("=== Delete Item ==="
                + ln + "Заявка удалена успешно." + ln));
        assertThat(tracker.findAll().size(), is(1));
    }

    @Test
    public void whenDeleteActionMockitoThenFail() {
        Output output = new StudOutput();
        MemTracker tracker = new MemTracker();
        Item item1 = new Item();
        item1.setName("item1");
        Item item2 = new Item();
        item1.setName("item2");
        tracker.add(item1);
        tracker.add(item2);
        DeleteAction deleteAction = new DeleteAction(output);
        Input input = mock(Input.class);
        deleteAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is("=== Delete Item ==="
                + ln + "Ошибка удаления заявки." + ln));
        assertThat(tracker.findAll().size(), is(2));
    }
}