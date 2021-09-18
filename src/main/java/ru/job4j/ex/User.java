package ru.job4j.ex;

/**
 * 1.2.5.Исключения
 * 0.5.Иерархия исключений и множественный catch.[#219368#127033]
 *
 * @since 18.09.2021
 */
public class User {

    private String username;
    private boolean valid;

    public User(String username, boolean valid) {
        this.username = username;
        this.valid = valid;
    }

    public String getUsername() {
        return username;
    }

    public boolean isValid() {
        return valid;
    }

    @Override
    public String toString() {
        return "User{" + "username='"
                + username + '\''
                + ", valid=" + valid + '}';
    }
}
