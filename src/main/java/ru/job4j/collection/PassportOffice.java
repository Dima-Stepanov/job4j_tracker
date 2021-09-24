package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.3.3.Map.HashMap.LinkedHashMap
 * 1.Паспорт и жители[#212656#127213]
 *
 * @since 24.09.2021
 */
public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        if (!citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
            rsl = true;
        }
        return rsl;
    }

    public Citizen get(String passport) {
        return citizens.get(passport);
    }
}
