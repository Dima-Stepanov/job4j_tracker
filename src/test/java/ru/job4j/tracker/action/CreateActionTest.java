package ru.job4j.tracker.action;

import org.junit.Test;
import ru.job4j.tracker.MemTracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StudInput;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StudOutput;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 3. Мидл
 * 3.2.1. Web
 * 3.2.8. Spring Test, Mockito
 * 1. Что такое Mock-объект. [#504866]
 * CreateActionTest. Mockito.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 12.04.2022
 */
public class CreateActionTest {
    @Test
    public void whenCreateActionMockitoThenOk() {
        Output output = new StudOutput();
        MemTracker tracker = new MemTracker();
        CreateAction createAction = new CreateAction(output);
        Input input = mock(Input.class);
        String nameItem = "newItem";
        when(input.askStr(any(String.class))).thenReturn(nameItem);
        createAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is("=== Create a new Item ==="
                + ln + "Добавлена заявка: "
                + new Item(1, nameItem) + ln));
        assertThat(tracker.findAll().get(0).getName(), is(nameItem));
    }
}