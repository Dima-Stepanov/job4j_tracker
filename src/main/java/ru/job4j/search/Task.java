package ru.job4j.search;

/**
 * 1.3.1.Коллекция List,ArrayList
 * 2.Очередь с приоритетом на LinkedList[#41670#127192]
 *
 * @since 22.09.2021
 */
public class Task {
    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}
