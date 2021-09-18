package ru.job4j.ex;

/**
 * 1.2.5.Исключения
 * 3.Замена if-else-throw на if-throw[#49895#127043]
 *
 * @since 19.09.2021
 */
public class Find {
    public static String get(String[] data, int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException(
                    "Index out of bound");
        }
        return data[index];
    }

    public static void main(String[] args) {
        String[] data = {"one", "two", "three"};
        String rsl = Find.get(data, 1);
        System.out.println(rsl);
    }
}
