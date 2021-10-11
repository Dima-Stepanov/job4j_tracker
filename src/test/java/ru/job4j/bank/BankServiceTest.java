package ru.job4j.bank;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * 1.3.3.Map.HashMap.LinkedHashMap
 * 3.Банковские переводы[#10038#127210]test
 * 1.4.3.Улучшенное Java API
 * 3.Optional в банковских переводах.[#214711#127085]test
 *
 * @since 24.09.2021
 * @since 11.10.2021
 */
public class BankServiceTest {
    @Test
    public void addUserOne() {
        BankService bankService = new BankService();
        User user1 = new User("123", "Petr");
        bankService.addUser(user1);
        assertThat(bankService.findByPassport(user1.getPassport()).get(), is(user1));
    }

    @Test
    public void whenAddUserTwo() {
        BankService bankService = new BankService();
        User user1 = new User("123", "Petr");
        User user2 = new User("345", "Dima");
        bankService.addUser(user1);
        bankService.addUser(user2);
        assertThat(bankService.findByPassport(user2.getPassport()).get(), is(user2));
    }

    @Test
    public void whenAddTwoUserEqualsPassport() {
        BankService bankService = new BankService();
        User user1 = new User("123", "Petr");
        User user2 = new User("123", "Dima");
        bankService.addUser(user1);
        bankService.addUser(user2);
        assertThat(bankService.findByPassport(user2.getPassport()).get().getUsername(),
                is(user1.getUsername()));
    }

    @Test
    public void deleteUser() {
        BankService bankService = new BankService();
        User user1 = new User("123", "Petr");
        User user2 = new User("456", "Dima");
        bankService.addUser(user1);
        bankService.addUser(user2);
        bankService.deleteUser(user1.getPassport());
        assertThat(bankService.findByPassport(user1.getPassport()), is(Optional.empty()));
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("3434", "5546").get().getBalance(), is(150D));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("34", "5546"), is(Optional.empty()));
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "113").get().getBalance(), is(200D));
    }
}