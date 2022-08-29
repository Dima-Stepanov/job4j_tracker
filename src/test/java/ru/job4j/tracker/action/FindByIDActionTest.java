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
 * FindByIDActionTest. Mockito.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 12.04.2022
 */
public class FindByIDActionTest {

    @Test
    public void whenFindByIDActionMockitoThenOk() {
        Output output = new StudOutput();
        MemTracker tracker = new MemTracker();
        Item item1 = new Item();
        item1.setName("item id 1");
        Item item2 = new Item();
        item2.setName("item id 2");
        tracker.add(item1);
        tracker.add(item2);
        FindByIDAction find = new FindByIDAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is("=== Find Item by ID ==="
                + ln + tracker.findAll().get(0) + ln));
        assertThat(tracker.findAll().get(1).getName(), is("item id 2"));
    }

    @Test
    public void whenFindByIDActionMockitoThenFail() {
        Output output = new StudOutput();
        MemTracker tracker = new MemTracker();
        Item item1 = new Item();
        item1.setName("item id 1");
        Item item2 = new Item();
        item2.setName("item id 2");
        tracker.add(item1);
        tracker.add(item2);
        FindByIDAction find = new FindByIDAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(10);
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is("=== Find Item by ID ==="
                + ln + "Заявка с введенным id: " + 10 + " не найдена." + ln));
        assertThat(tracker.findAll().get(0).getName(), is("item id 1"));
    }
}