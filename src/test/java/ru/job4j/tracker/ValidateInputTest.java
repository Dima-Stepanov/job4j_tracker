package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * 1.2.5.Исключения
 * 2.1.Тест на ValidateInput[#311887]
 *
 * @since 19.09.2021
 */
public class ValidateInputTest {

    @Test
    public void askInvalidInput() {
        Output out = new StudOutput();
        Input in = new StudInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(out.toString(), is("Please enter validate data again."
                + System.lineSeparator()));
        assertThat(selected, is(1));
    }

    @Test
    public void whenAskValidInput5() {
        Output out = new StudOutput();
        Input in = new StudInput(new String[]{"5"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(5));
    }

    @Test
    public void whenAskValidInpet5on3on2Then5() {
        Output out = new StudOutput();
        Input in = new StudInput(new String[]{"5", "3", "2"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(5));
    }

    @Test
    public void whenAskValidInputNegative5ThenNegative5() {
        Output out = new StudOutput();
        Input in = new StudInput(new String[]{"-5"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-5));
    }

}