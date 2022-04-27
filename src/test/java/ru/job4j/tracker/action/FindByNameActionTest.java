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
 * FindByNameActionTest. Mockito.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 12.04.2022
 */
public class FindByNameActionTest {

    @Test
    public void whenFindByNameMockitoThenOk() {
        Output output = new StudOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("item id 1"));
        tracker.add(new Item("item id 2"));
        FindByNameAction find = new FindByNameAction(output);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("item id 2");
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is("=== Find Item by NAME ==="
                + ln + tracker.findAll().get(1) + ln));
    }

    @Test
    public void whenFindByNameMockitoThenFail() {
        Output output = new StudOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("item id 1"));
        tracker.add(new Item("item id 2"));
        FindByNameAction find = new FindByNameAction(output);
        Input input = mock(Input.class);
        String findName = "not found";
        when(input.askStr(any(String.class))).thenReturn(findName);
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is("=== Find Item by NAME ===" + ln + "Заявки с именем: "
                + findName + " не найдены." + ln));
        assertThat(tracker.findAll().size(), is(2));
    }
}