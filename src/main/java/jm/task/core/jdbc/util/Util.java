package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static Connection connection;
    private static boolean isConnected = false;

    private Util() {}

    public static void initializeConnection() {
        if (!isConnected) {
            try {
                // Загрузка драйвера MySQL
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Настройка свойств подключения
                Properties properties = new Properties();
                properties.setProperty("user", "root");
                properties.setProperty("password", "rooot");

                // Подключение к базе данных
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/test_db",
                        properties
                );

                // Проверка подключения
                if (connection != null) {
                    System.out.println("Successfully connected to the database!");
                } else {
                    System.err.println("Failed to connect to the database.");
                }

                isConnected = true;
            } catch (ClassNotFoundException e) {
                System.err.println("MySQL JDBC driver not found!");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("Error connecting to the database!");
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() {
        if (!isConnected || connection == null) {
            initializeConnection();
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed successfully.");
                isConnected = false;
            } catch (SQLException e) {
                System.err.println("Error closing connection!");
                e.printStackTrace();
            }
        }
    }
}
