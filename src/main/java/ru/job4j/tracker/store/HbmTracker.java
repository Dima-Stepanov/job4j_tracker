package ru.job4j.tracker.store;

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
 * 1. HbmTracker. [#287705]
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 28.04.2022
 */
public class HbmTracker implements Store {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sessionFactory = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        int result = session.createQuery("update ru.job4j.tracker.model.Item "
                        + "set name = :nameItem, created = :createdItem "
                        + "where id = :idItem")
                .setParameter("nameItem", item.getName())
                .setParameter("createdItem", item.getCreated())
                .setParameter("idItem", id)
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result > 0;
    }

    @Override
    public boolean delete(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        int result = session.createQuery("delete ru.job4j.tracker.model.Item "
                        + "where id = :idItem")
                .setParameter("idItem", id)
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result > 0;
    }

    @Override
    public List<Item> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session
                .createQuery("from ru.job4j.tracker.model.Item")
                .list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session
                .createQuery("from ru.job4j.tracker.model.Item where name = :nameItem")
                .setParameter("nameItem", key)
                .list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public Item findById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Item result = session.get(ru.job4j.tracker.model.Item.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
