package ru.job4j.ex;

/**
 * 1.2.5.Исключения
 * 0.6.Error-исключения,
 * связанные с работой виртуальной машины[#219370#127038]
 *
 * @since 18.09.2021
 */
public class FactRec {
    /**
     * вычисление факториала черех рекурсию.
     *
     * @param n int
     * @return фкториал
     */
    public static int calc(int n) {
        System.out.println(n);
        if (n == 0 || n == 1) {
            return 1;
        }
        return calc(n - 1) * n;
    }

    public static void main(String[] args) {
        int rsl = calc(3);
        System.out.println(rsl);
    }
}
