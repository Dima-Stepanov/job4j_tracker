package ru.job4j.bank;

import java.util.*;

/**
 * 1.3.3.Map.HashMap.LinkedHashMap
 * 3.Банковские переводы[#10038#127210]
 * Главный сервис ru.job4j.bank.BankService.
 *
 * @author Dmitry
 * @version 1
 * @since 24.09.2021
 */
public class BankService {
    /**
     * Для хранения счетов пользователей используется HashMap
     * В качестве ключа модель данных User, для значения модель данных Account
     */
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
     * Удаление пользователя из систему по номеру паспорта
     *
     * @param passport User passport для удаления
     * @return boolean true false.
     */
    public boolean deleteUser(String passport) {
        User user = findByPassport(passport);
        boolean rsl = false;
        if (user != null) {
            users.remove(user);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Добавление нового счета к пользователю.
     * По номеру паспорта ищем пользователя, если находим проверяем есть ли такой аккаунт.
     *
     * @param passport Ключ поиска номер паспорта
     * @param account  Account
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
     * @return User возвращает модель данных если найдена или null
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
     * Поиск счета пользователя по паспорту и реквизитам.
     *
     * @param passport  Номер паспорта User
     * @param requisite Реквизиты Account
     * @return Account или null
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

    /**
     * Перечисление средств со счета src на счет dest.
     * Счета не найдены или средств не достаточно вернуть false.
     *
     * @param srcPassport   паспорт пользователя списания
     * @param srcRequisite  счет списания
     * @param destPassport  паспорт пользователя зачисления
     * @param destRequisite счет зачисления
     * @param amount        сумма перевода.
     * @return boolean true false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        boolean rsl = srcAccount != null
                && destAccount != null
                && srcAccount.getBalance() >= amount;
        if (rsl) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
        }
        return rsl;
    }
}
