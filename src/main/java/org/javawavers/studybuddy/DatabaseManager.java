package org.javawavers.studybuddy;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private static final String DATABASE_URL = "jdbc:sqlite:src/main/resources/org/javawavers/studybuddy/DataBase.db";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(DATABASE_URL);
        } catch (SQLException e) {
            System.out.println("Trouble connecting:" + e);
            return null;
        }
    }

    public static void CreateUserProfile() {
        try (Connection c = DatabaseManager.connect()) {
            assert c != null;
            try (Statement s = c.createStatement()) {
                String sql = """
                        CREATE TABLE IF NOT EXISTS userProfile (
                        username TEXT PRIMARY KEY,
                        password TEXT NOT NULL,
                        email TEXT NOT NULL,
                        name TEXT NOT NULL
                        ) WITHOUT ROWID ;
                        """;
                s.execute(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
