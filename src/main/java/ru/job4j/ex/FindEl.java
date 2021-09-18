package ru.job4j.ex;

/**
 * 1.2.5.Исключения
 * 0.4.Пользовательские исключения.[#219367#127041]
 * 0.5.Иерархия исключений и множественный catch.[#219368#127033]
 *
 * @since 18.09.2021
 */
public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Item value not found");
        }
        return rsl;
    }

    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {
        boolean rsl = true;
        for (String abuse : abuses) {
            if (value.equals(abuse)) {
                rsl = false;
                break;
            }
        }
        if (!rsl) {
            throw new ElementAbuseException("Message is included in the list of blocked messages");
        }
        return rsl;
    }

    public static void process(String[] value, String key, String[] abuses) {
        try {
            if (indexOf(value, key) != -1) {
                sent(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
