package ru.job4j.oop;

/**
 * 1.2.1.Классы и объекты
 * 1.7.Конструктор[#173889#127060]
 */
public class Error {
    private boolean active;
    private int status;
    private String message;

    /**
     * Конструктор по умолчанию.
     */
    public Error() {
    }

    /**
     * Конструктор с определениями переменных.
     *
     * @param active  boolean
     * @param status  int
     * @param message String
     */
    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    /**
     * Вывод содержимого полей.
     */
    public void printInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        Error err = new Error(true, 1, "Hello");
        err.printInfo();
    }
}
