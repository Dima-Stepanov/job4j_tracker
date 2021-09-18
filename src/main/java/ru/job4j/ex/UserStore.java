package ru.job4j.ex;

/**
 * 1.2.5.Исключения
 * 0.5.Иерархия исключений и множественный catch.[#219368#127033]
 *
 * @since 18.09.2021
 */
public class UserStore {
    /**
     * Поиск пользователя в списке
     *
     * @param users User[]
     * @param login String
     * @return User
     * @throws UserNotFoundException exception
     */
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (User item : users) {
            if (login.equals(item.getUsername())) {
                user = item;
                break;
            }
        }
        System.out.println(user);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return user;
    }

    /**
     * Проверка пользователя на валидность
     *
     * @param user Гыук
     * @return boolean
     * @throws UserInvalidException exception
     */
    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() && user.getUsername().length() > 3) {
            throw new UserInvalidException("User is not validate");
        }
        return user.isValid() && user.getUsername().length() > 3;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ui) {
            ui.printStackTrace();
        } catch (UserNotFoundException un) {
            un.printStackTrace();
        }
    }
}
