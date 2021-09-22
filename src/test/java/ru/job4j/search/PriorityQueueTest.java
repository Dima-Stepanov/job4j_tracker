package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * 1.3.1.Коллекция List,ArrayList
 * 2.Очередь с приоритетом на LinkedList[#41670#127192]test
 *
 * @since 22.09.2021
 */
public class PriorityQueueTest {

    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        queue.put(new Task("izee", 6));
        queue.put(new Task("ran", 6));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }
}