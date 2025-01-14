package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.tracker.model.Item;

import java.util.List;

/**
 * 3. Мидл
 * 3.3. Hibernate
 * 3.3.1. Конфигурирование
 * 0. Конфигурация Hibernate [#6872]
 * HibernateRun.class Демонстрация операции создания,
 * редактирования, удаления и чтения модели Item, при помощи Hibernate.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 27.04.2022
 */
public class HibernateRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
            Item item1 = new Item();
            item1.setName("Item1");
            item1.setDescription("description Item1");
            create(item1, sessionFactory);
            Item item2 = new Item();
            item2.setName("Item2");
            item2.setDescription("description Item2");
            create(item2, sessionFactory);
            System.out.println("create: " + item1);
            System.out.println("create2: " + item2);
            item1.setName("Learn Hibernate 5.");
            update(item1, sessionFactory);
            System.out.println("update: " + item1);
            Item rsl = findByID(item1.getId(), sessionFactory);
            System.out.println("Find by ID: " + rsl);
            List<Item> listItem = findAll(sessionFactory);
            for (Item it : listItem) {
                System.out.println("Find ALL: " + it);
            }
            delete(rsl.getId(), sessionFactory);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static Item create(Item item, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    public static void update(Item item, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
        session.close();
    }

    public static void delete(Integer id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Item item = new Item();
        item.setId(id);
        session.delete(item);
        session.getTransaction().commit();
        session.close();
    }

    public static List<Item> findAll(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Item> result = session.createQuery("from ru.job4j.tracker.model.Item").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public static Item findByID(Integer id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Item result = session.get(Item.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
