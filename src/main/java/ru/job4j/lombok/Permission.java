package ru.job4j.lombok;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

/**
 * 3. Мидл
 * 3.3. Hibernate
 * 3.3.1. Lombok
 * 3. @Builder [#504890]
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 29.08.2022
 */
@Builder(builderMethodName = "of")
@ToString
@Getter
public class Permission {
    private int id;
    private String name;
    @Singular("rulesBy")
    private List<String> rules;
}
