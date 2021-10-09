package ru.job4j.stream.card;

import java.util.List;
import java.util.stream.Stream;

/**
 * 1.4.2. Stream API
 * 8. Перенос методов в Stream API[#279131]
 * Класс карты карточной колоды масть + значение.
 *
 * @author Dima_Nout
 * @version 1
 * @since 10.10.2021
 */
public class Card {
    private Suit suit;
    private Value value;

    /**
     * Конструктор.
     *
     * @param suit  Suit
     * @param value Value
     */
    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    /**
     * Метод MAIN собирает колоду.
     *
     * @param args null.
     */
    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .map(value -> new Card(suit, value)))
                .forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Card{"
                + "suit=" + suit
                + ", value=" + value
                + '}';
    }
}
