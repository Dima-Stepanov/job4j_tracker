package ru.job4j.bank;

import java.util.*;

/**
 * 1.3.3.Map.HashMap.LinkedHashMap
 * 3.Банковские переводы[#10038#127210]
 * главный сервис ru.job4j.bank.BankService.
 *
 * @since 24.09.2021
 */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляем нового пользователя с пустым списком аккаунтов
     *
     * @param user Пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Добавление нового счета к пользователю.
     *
     * @param passport Ключ поиска номер паспорта
     * @param account Account
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Поиск пользователя по номеру паспорта
     *
     * @param passport Номер паспорта
     * @return User
     */
    public User findByPassport(String passport) {
        User userPassport = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                userPassport = user;
                break;
            }
        }
        return userPassport;
    }

    /**
     * Поиск счета пользователя по реквизитам
     *
     * @param passport  Номер паспорта User
     * @param requisite Реквизиты Account
     * @return Account
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account accountUser = null;
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    accountUser = account;
                    break;
                }
            }
        }
        return accountUser;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        return false;
    }
}
