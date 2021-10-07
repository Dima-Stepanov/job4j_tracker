package ru.job4j.stream;

import java.util.List;

/**
 * 1.4.2.Stream API
 * 0.1.Отладка лямбда в IDEA[#259165]
 *
 * @author Dmitry
 * @version 1
 * @since 07.10.2021
 */
public class StreamUsage {

    public static class Task {
        /**
         * Поля класса
         */
        private final String name;
        private final long spent;

        /**
         * Конструктор класса
         *
         * @param name  Имя задачи
         * @param spent Потраченное время
         */
        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 10),
                new Task("Task #2", 20),
                new Task("Bug #3", 40)
        );
        tasks.stream()
                .filter(task -> task.name.contains("Bug"))
                .filter(task -> task.spent > 30)
                .map(task -> task.name)
                .forEach(System.out::println);
    }
}
