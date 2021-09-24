package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 1.3.2.Коллекция Set,HashSet
 * 3.Модели данных и HashSet.[#218530#127208]test
 *
 * @since 24.09.2021
 */
public class NotifyAccountTest {

    @Test
    public void whenSentNotEqualsAccount() {
        List<Account> accounts = Arrays.asList(
                new Account("1234", "Petr", "eDer3432f"),
                new Account("142", "Petr", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("1234", "Petr", "eDer3432f"),
                        new Account("142", "Petr", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void whenSentEqualsAccount() {
        List<Account> accounts = Arrays.asList(
                new Account("1234", "Petr", "eDer3432f"),
                new Account("142", "Petr", "000001"),
                new Account("1234", "Petr", "eDer3432f"),
                new Account("142", "Petr", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("1234", "Petr", "eDer3432f"),
                        new Account("142", "Petr", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }
}