package ru.job4j.pojo;

/**
 * 1.2.3.Инкапсуляция
 * 3.Массивы и модели.[#174892#127068]
 *
 * @since 11.09.2021
 */
public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Idiot", 250);
        Book book2 = new Book("Maygly", 350);
        Book book3 = new Book("War", 1500);
        Book book4 = new Book("Clean code", 2500);
        Book[] books = new Book[]{book1, book2, book3, book4};
        for (Book book : books) {
            System.out.println(book.getName() + " - "
                    + book.getSheet());
        }
        Book temp;
        temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println("Переставьте местами книги с индексом 0 и 3");
        for (Book book : books) {
            System.out.println(book.getName() + " - "
                    + book.getSheet());
        }
        System.out.println("выводом книг с именем \"Clean code\"");
        for (Book book : books) {
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName() + " - "
                        + book.getSheet());
            }
        }
    }
}
