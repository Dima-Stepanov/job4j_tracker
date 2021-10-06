package ru.job4j.function;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.Assert.*;

/**
 * 1.4.1.Lambda
 * 1.3.Встроенные функциональные интерфейсы.[#249209]test
 *
 * @author Dmitry
 * @version 1
 * @since 21.10.2021
 */
public class SearchFolderTest {

    @Test
    public void whenFilterSizeMore100() {
        List<Folder> list = List.of(
                new Folder("fix", 110),
                new Folder("bug", 75),
                new Folder("bug", 90)
        );
        List<Folder> expected = List.of(new Folder("fix", 110));
        List<Folder> rsl = SearchFolder.filter(list, f -> f.getSize() > 100);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenFilterSezeLess100() {
        List<Folder> list = List.of(
                new Folder("fix", 110),
                new Folder("bug", 75),
                new Folder("bug", 90)
        );
        List<Folder> expected = List.of(
                new Folder("bug", 75),
                new Folder("bug", 90)
        );
        List<Folder> rsl = SearchFolder.filter(list, f -> f.getSize() < 100);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenFilterName() {
        List<Folder> list = List.of(
                new Folder("fix", 110),
                new Folder("bug", 75),
                new Folder("bug", 90)
        );
        List<Folder> expected = List.of(
                new Folder("bug", 75),
                new Folder("bug", 90)
        );
        List<Folder> rsl = SearchFolder.filter(list, f -> f.getName().contains("bug"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenFilterNameEqualsFix() {
        List<Folder> list = List.of(
                new Folder("fix", 110),
                new Folder("bugfix", 75),
                new Folder("fixbug", 90)
        );
        List<Folder> expected = List.of(
                new Folder("fix", 110)
        );
        List<Folder> rsl = SearchFolder.filter(list, f -> f.getName().equals("fix"));
        assertThat(rsl, is(expected));
    }
}