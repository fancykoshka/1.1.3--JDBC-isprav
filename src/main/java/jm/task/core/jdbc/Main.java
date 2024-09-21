package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    private final static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        userService.createUsersTable();

        userService.saveUser("Alina", "Ga", (byte) 25);
        userService.saveUser("Milana", "Dzha", (byte) 24);
        userService.saveUser("Alana", "Besta", (byte) 27);
        userService.saveUser("Toma", "Gul", (byte) 28);

        userService.removeUserById(2);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();

        Util.closeConnection();
    }
}
