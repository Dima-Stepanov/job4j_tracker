package ru.job4j.lombok;

import lombok.*;

/**
 * 3. Мидл
 * 3.3. Hibernate
 * 3.3.1. Lombok
 * 2. @Setter, @Getter и другие [#504889]
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 29.08.2022
 */
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class Category {
    @NonNull
    @Getter
    @EqualsAndHashCode.Include
    private int id;
    @Getter
    @Setter
    private String name;
}
