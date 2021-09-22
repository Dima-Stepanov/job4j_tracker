package ru.job4j.search;

import java.util.LinkedList;

/**
 * 1.3.1.Коллекция List,ArrayList
 * 2.Очередь с приоритетом на LinkedList[#41670#127192]
 *
 * @since 22.09.2021
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int index = 0;
        for (Task element : tasks) {
            if (task.getPriority() < element.getPriority()) {
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return tasks.poll();
    }
}
