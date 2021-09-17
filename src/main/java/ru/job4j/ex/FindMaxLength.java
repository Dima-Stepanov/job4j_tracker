package ru.job4j.ex;

/**
 * 1.2.5.Исключения
 * 0.1.java.lang.NullPointerException[#219364#127040]
 *
 * @since 17.09.2021
 */
public class FindMaxLength {
    public static void main(String[] args) {
        String[] shops = {"Ebay", null, "Amazon", null, "Ozon"};
        int max = 0;
        for (String shop : shops) {
            if (shop != null && shop.length() > max) {
                max = shop.length();
            }
        }
        System.out.println("Max length : " + max);
    }
}
