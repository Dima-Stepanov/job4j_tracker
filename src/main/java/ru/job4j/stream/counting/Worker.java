package ru.job4j.stream.counting;

/**
 * Упражнения JavaCore
 * 1.4.2. Stream API
 * 2.2. Группировка элементов и подсчет количества. Метод counting()
 * Модель Worker
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 30.06.2022
 */
public class Worker {
    private int age;
    private Company company;

    public Worker(int age, Company company) {
        this.age = age;
        this.company = company;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
