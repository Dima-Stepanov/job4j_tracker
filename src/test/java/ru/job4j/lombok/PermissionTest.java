package ru.job4j.lombok;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 3. Мидл
 * 3.3. Hibernate
 * 3.3.1. Lombok
 * 3. @Builder [#504890]
 * Test
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 29.08.2022
 */
public class PermissionTest {

    @Test
    public void testBuilder() {
        Permission permission = Permission.of()
                .id(1)
                .name("Administrator")
                .rulesBy("ROLE_ADMIN")
                .rulesBy("ROLE_USER")
                .build();
        assertEquals(permission.getId(), 1);
        assertEquals(permission.getName(), "Administrator");
        assertEquals(permission.getRules().size(), 2);
    }
}