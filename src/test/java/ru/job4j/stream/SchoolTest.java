package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 1.4.2.Stream API
 * 1.Фильтрация учеников[#110058#127091]test
 *
 * @author Dmitry
 * @version 1
 * @since 07.10.2021
 */
public class SchoolTest {

    @Test
    public void whenCollectClassA() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(40, "Surname4"),
                new Student(50, "Surname5"),
                new Student(60, "Surname6"),
                new Student(70, "Surname7"),
                new Student(90, "Surname9")
        );
        School sc = new School();
        Predicate<Student> pr = student -> student.getScore() >= 70;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = List.of(
                new Student(70, "Surname7"),
                new Student(90, "Surname9")
        );
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassB() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(40, "Surname4"),
                new Student(50, "Surname5"),
                new Student(60, "Surname6"),
                new Student(70, "Surname7"),
                new Student(90, "Surname9")
        );
        School sc = new School();
        Predicate<Student> pr = student -> student.getScore() < 70 && student.getScore() >= 50;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = List.of(
                new Student(50, "Surname5"),
                new Student(60, "Surname6")
        );
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassC() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(20, "Surname2"),
                new Student(30, "Surname3"),
                new Student(40, "Surname4"),
                new Student(50, "Surname5"),
                new Student(60, "Surname6"),
                new Student(70, "Surname7"),
                new Student(90, "Surname9")
        );
        School sc = new School();
        Predicate<Student> pr = student -> student.getScore() < 50;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = List.of(
                new Student(10, "Surname1"),
                new Student(20, "Surname2"),
                new Student(30, "Surname3"),
                new Student(40, "Surname4")
        );
        assertThat(rsl, is(expected));
    }
}