package ru.job4j.tracker.input;

/**
 * 1.2.4.Полиморфизм
 * 3.Интерфейс Input[#181092#127027]
 * 5.Input и полиморфизм.[#181094#127031]
 *
 * @since 14.10.2021
 */
public class StudInput implements Input {
    private String[] answers;
    private int position = 0;

    public StudInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String askStr(String question) {
        return answers[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
