package ru.job4j.bank;

import java.util.*;

/**
 * 1.3.3.Map.HashMap.LinkedHashMap
 * 3.Банковские переводы[#10038#127210]
 * Главный сервис ru.job4j.bank.BankService.
 * 1.4.2. Stream API.
 * 6.Тестовое задание из модуля коллекции
 * Lite переделать на Stream API.[#24260 #127094]задача.
 * 1.4.3.Улучшенное Java API
 * 3.Optional в банковских переводах.[#214711#127085]
 *
 * @author Dmitry
 * @version 3
 * @since 24.09.2021
 * @since 10.10.2021
 * @since 11.10.2021
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
        Optional<User> user = findByPassport(passport);
        boolean rsl = false;
        if (user.isPresent()) {
            users.remove(user.get());
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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * Поиск пользователя по номеру паспорта
     * 10.10.2021 переделан на Stream API
     *
     * @param passport Номер паспорта
     * @return User возвращает модель данных если найдена или null
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Поиск счета пользователя по паспорту и реквизитам.
     * 10.10.2021 переделан на Stream API
     *
     * @param passport  Номер паспорта User
     * @param requisite Реквизиты Account
     * @return Account или null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return users.get(user.get()).stream()
                .filter(account -> account.getRequisite().equals(requisite))
                .findFirst();
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        boolean rsl = srcAccount.isPresent()
                && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount;
        if (rsl) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
        }
        return rsl;
    }
}
