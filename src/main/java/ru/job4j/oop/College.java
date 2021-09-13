package ru.job4j.oop;

/**
 * 1.2.4.Полиморфизм
 * 3.1.Приведение типов.Повышение типа и понижение типа.[#181322#127028]
 *
 * @since 14.10.2021
 */
public class College {
    /**
     * Приведение типов UP CASTING
     */
    public void typ() {
        Freshman freshman = new Freshman();
        Student student = freshman;
        Object object = freshman;
        Student stud = new Freshman();
        Object obj = new Freshman();
        Object obj1 = new Student();
    }
}
