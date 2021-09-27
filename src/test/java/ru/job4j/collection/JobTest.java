package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 1.3.4.Сортировка
 * 2.Комбинированный компаратор[#10036#127205]test
 *
 * @since 27.09.2021
 */
public class JobTest {

    @Test
    public void whenJobSotrByName() {
        Comparator<Job> comparatorName = new SortByNameJob();
        int rsl = comparatorName.compare(
                new Job("Dima", 30),
                new Job("Vova", 30)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenJobSotrByNameDesc() {
        Comparator<Job> comparatorName = new JobDescByName();
        int rsl = comparatorName.compare(
                new Job("Dima", 30),
                new Job("Vova", 30)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenJobSortByPriority() {
        Comparator<Job> comparatorPriority = new SortByPriority();
        int rsl = comparatorPriority.compare(
                new Job("Dima", 33),
                new Job("Vova", 30)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenJobSortByPriorityDesc() {
        Comparator<Job> comparatorPriority = new JobDescByPriority();
        int rsl = comparatorPriority.compare(
                new Job("Dima", 33),
                new Job("Vova", 30)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority =
                new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriorityDesc() {
        Comparator<Job> cmpNamePriorityDesc =
                new SortByNameJob().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriorityDesc.compare(
                new Job("Impl", 0),
                new Job("Fix", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
}