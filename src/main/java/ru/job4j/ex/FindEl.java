package ru.job4j.ex;

/**
 * 1.2.5.Исключения
 * 0.4.Пользовательские исключения.[#219367#127041]
 *
 * @since 17.09.2021
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

    public static void main(String[] args) {
        String[] value = {"first", "second", "third", "four"};
        String key = "thir";
        int rsl = -1;
        try {
            rsl = indexOf(value, key);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(rsl);
    }
}
