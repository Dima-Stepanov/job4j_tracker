package ru.job4j.tracker;

/**
 * 1.2.6.ООА\П
 * 2. Singleton [#94606]
 *
 * @since 19.09.2021
 */
public final class Log4File {

    private static Log4File instance = null;
    private String[] messages = new String[1000];
    private int index = 0;

    private Log4File() {
    }

    public static Log4File getInstance() {
        if (instance == null) {
            instance = new Log4File();
        }
        return instance;
    }

    public void add(String message) {
        messages[index] = message;
    }

    public void save() {
        /*TODO Сохраняем записи из массива messages в файл.*/
    }
}
