package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.SqlTracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

/**
 * 2.3.5. JDBC
 * 3. Liquibase. Интеграционные тесты. [#95881]
 *
 * @author Dima_Nout
 * @since 01.01.2022
 */
public class SqlTrackerTest {
    private static Connection connection;

    /**
     * Данный метод запускается 1 раз в начале запуска всего теста,
     * выполняется инициализация подключения.
     * Данный метод обозначен аннотацией @BeforeClass,
     * т.е. метод выполняется один раз до начала тестов;
     */
    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest
                .class.getClassLoader()
                .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * В методе closeConnection() выполняется закрытие подключения.
     * Данный метод обозначен аннотацией @AfterClass,
     * т.е. метод выполняется один раз после тестов;
     */
    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    /**
     * В методе wipeTable() мы чистим таблицу items после внесенных изменений.
     * Делается это специально, чтобы облегчить тестирование,
     * иначе изменения, внесенные одним тестом, будут видны другому.
     * Данный метод обозначен аннотацией @After,
     * т.е. метод выполняется после каждого теста;
     */
    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item();
        item.setName("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenSaveTwoItemAndFindByItem1Itme2ThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item();
        item1.setName("Item1");
        Item item2 = new Item();
        item2.setName("Item2");
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findById(item2.getId()), is(item2));
        assertThat(tracker.findById(item1.getId()), is(item1));
    }

    @Test
    public void whenReplaceItemAndFindByIdThenEqualsNewItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item();
        item.setName("item");
        Item itemNew = new Item();
        itemNew.setName("itemNew");
        tracker.add(item);
        tracker.replace(item.getId(), itemNew);
        assertThat(tracker.findById(item.getId()).getName(), is(itemNew.getName()));
        assertThat(tracker.findById(item.getId()).getCreated(), is(itemNew.getCreated()));
    }

    @Test
    public void whenDeleteItemAndFindByIdThenNull() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item();
        item.setName("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
        tracker.delete(item.getId());
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenFindByAllThenExpectedEqualsResult() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item();
        item1.setName("Item1");
        Item item2 = new Item();
        item2.setName("Item2");
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findAll(), is(List.of(item1, item2)));
    }

    @Test
    public void whenFindByNameOneItemThenExpectedEqualsResult() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item();
        item1.setName("Item");
        Item item2 = new Item();
        item2.setName("Item1");
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findByName("Item"), is(List.of(item1)));
    }

    @Test
    public void whenFindByNameTwoItemThenExpectedEqualsResult() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item();
        item1.setName("Item");
        Item item2 = new Item();
        item2.setName("Item");
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findByName("Item"), is(List.of(item1, item2)));
    }

    @Test
    public void whenFindByIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item();
        item1.setName("Item");
        Item item2 = new Item();
        item2.setName("Item1");
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findById(item2.getId()), is(item2));
    }

    @Test
    public void whenFindByIdThenNull() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item();
        item1.setName("Item");
        Item item2 = new Item();
        item2.setName("Item1");
        tracker.add(item1);
        tracker.add(item2);
        tracker.delete(item2.getId());
        assertNull(tracker.findById(item2.getId()));
    }
}