package ru.job4j.tracker.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.tracker.model.Item;

import java.util.List;
import java.util.function.Function;

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
        return tx(session -> {
            session.save(item);
            return item;
        });
    }

    @Override
    public boolean replace(int id, Item item) {
        return tx(session ->
                session.createQuery("update Item "
                                + "set name = :nameItem, created = :createdItem "
                                + "where id = :idItem")
                        .setParameter("nameItem", item.getName())
                        .setParameter("createdItem", item.getCreated())
                        .setParameter("idItem", id)
                        .executeUpdate() > 0
        );
    }

    @Override
    public boolean delete(int id) {
        return tx(session -> session.createQuery("delete Item "
                        + "where id = :idItem")
                .setParameter("idItem", id)
                .executeUpdate() > 0);
    }

    @Override
    public List<Item> findAll() {
        return tx(session -> session
                .createQuery("from Item")
                .list());
    }

    @Override
    public List<Item> findByName(String key) {
        return tx(session -> session
                .createQuery("from Item where name =: nameItem")
                .setParameter("nameItem", key)
                .list());
    }

    @Override
    public Item findById(int id) {
        return tx(session -> session.get(Item.class, id));
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }

    /**
     * Шаблон проектирования WRAPPER.
     *
     * @param command Function
     * @param <T>     T
     * @return T
     */
    private <T> T tx(final Function<Session, T> command) {
        final Session session = sessionFactory.openSession();
        final Transaction tx = session.beginTransaction();
        try (session) {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            tx.rollback();
            throw e;
        }
    }
}
