package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 1.4.2.Stream API
 * 1.Фильтрация учеников[#110058#127091]test
 * 4.Преобразование List в Map.[#110226#127089]test
 *
 * @author Dmitry
 * @version 1
 * @since 07.10.2021
 * @since 09.10.2021
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

    @Test
    public void whenListStudentsThenMapSurnameStudent() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(20, "Surname2"),
                new Student(30, "Surname3"),
                new Student(40, "Surname4")
        );
        School sc = new School();
        Map<String, Student> rsl = sc.toMap(students);
        Map<String, Student> expected = Map.of(
                "Surname1", new Student(10, "Surname1"),
                "Surname2", new Student(20, "Surname2"),
                "Surname3", new Student(30, "Surname3"),
                "Surname4", new Student(40, "Surname4")
        );
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenListStudentsThenMapSurnameStudentIsDubleSurname() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(20, "Surname2"),
                new Student(30, "Surname1")
        );
        School sc = new School();
        Map<String, Student> rsl = sc.toMap(students);
        Map<String, Student> expected = Map.of(
                "Surname1", new Student(30, "Surname1"),
                "Surname2", new Student(20, "Surname2")
        );
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenLevelOfThenBound3() {
        School sc = new School();
        List<Student> students = new ArrayList<>();
        students.add(new Student(3, "Surname1"));
        students.add(new Student(5, "Surname2"));
        students.add(new Student(6, "Surname1"));
        List<Student> expected = List.of(
                new Student(6, "Surname1"),
                new Student(5, "Surname2")
        );
        List<Student> result = sc.levelOf(students, 3);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSorted() {
        List<Student> input = new ArrayList<>();
        School sc = new School();
        input.add(new Student(28, "Masha"));
        input.add(new Student(128, "Pety"));
        List<Student> expected = List.of(
                new Student(128, "Pety"),
                new Student(28, "Masha")
        );
        assertThat(sc.levelOf(input, 20), is(expected));
    }

    @Test
    public void whenOnlyNull() {
        School sc = new School();
        List<Student> input = new ArrayList<>();
        input.add(null);
        List<Student> expected = List.of();
        assertThat(sc.levelOf(input, 100), is(expected));
    }

    @Test
    public void whenHasNull() {
        School sc = new School();
        List<Student> input = new ArrayList<>();
        input.add(null);
        input.add(new Student(28, "Pety"));
        List<Student> expected = List.of(new Student(28, "Pety"));
        assertThat(sc.levelOf(input, 10), is(expected));
    }
}