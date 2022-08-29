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
 * ReplaceActionTest. Mockito.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 12.04.2022
 */
public class ReplaceActionTest {

    @Test
    public void whenReplaceActionMockitoThenReplaceOk() {
        Output output = new StudOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item();
        item.setName("Replaced item");
        tracker.add(item);
        String replaceName = "New item name";
        ReplaceAction rep = new ReplaceAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replaceName);
        rep.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is("=== Edit Item ==="
                + ln + "Заявка изменена успешно." + ln));
        assertThat(tracker.findAll().get(0).getName(), is(replaceName));
    }

    @Test
    public void whenReplaceActionMockitoThenReplaceFail() {
        Output output = new StudOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item();
        item.setName("Replaced item");
        tracker.add(item);
        String replaceName = "New item name";
        ReplaceAction rep = new ReplaceAction(output);
        Input input = mock(Input.class);
        rep.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is("=== Edit Item ==="
                + ln + "Ошибка замены заявки." + ln));
        assertThat(tracker.findAll().get(0).getName(), is("Replaced item"));
    }
}