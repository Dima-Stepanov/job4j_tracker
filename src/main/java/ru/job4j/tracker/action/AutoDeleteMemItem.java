package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;

/**
 * 2.4.3. Профилирование приложения.
 * 1. Профилирование. [#1591].
 * Удаляет все заявки из MemTracker.
 * In MemTracer only.
 *
 * @author Dmitry
 * @since 20.01.2022
 */
public class AutoDeleteMemItem implements UserAction {
    private final Output out;

    public AutoDeleteMemItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Auto delete items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Auto delete Items ===");
        int size = input.askInt("Enter numbers delete items:");
        for (int i = 1; i < size; i++) {
            if (tracker.delete(i)) {
                out.println("Заявка " + i + " удалена успешно.");
            } else {
                out.println("Ошибка удаления заявки " + i);
            }
        }
        return true;
    }
}
