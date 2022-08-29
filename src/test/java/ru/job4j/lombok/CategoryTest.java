package ru.job4j.lombok;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

/**
 * 3. Мидл
 * 3.3. Hibernate
 * 3.3.1. Lombok
 * 2. @Setter, @Getter и другие [#504889]
 * Test
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 29.08.2022
 */
public class CategoryTest {

    @Test
    public void constructorTest() {
        Category category = new Category(1);
        assertThat(category.getId(), is(1));
    }

    @Test
    public void testEqualsTrue() {
        Category category = new Category(1);
        category.setName("name1");
        Category category1 = new Category(1);
        category1.setName("name2");
        assertThat(category, is(category1));
    }

    @Test
    public void testEqualsFalse() {
        Category category = new Category(1);
        category.setName("name1");
        Category category1 = new Category(2);
        category1.setName("name2");
        assertNotEquals(category, category1);
    }
}