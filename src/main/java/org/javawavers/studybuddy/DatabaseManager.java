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

    public static void CreateTables() {
        CreateUserProfile();
        CreateSubject();
        CreateSubjectElement();
        CreateAssignment();
        CreateExam();
        CreateWeek();
        CreateDay();
        CreateAvailability();
        CreateScheduledTask();
    }

    public static void CreateUserProfile() {
        try (Connection c = DatabaseManager.connect();
             Statement s = c.createStatement()) {
            String sql = """
                    CREATE TABLE IF NOT EXISTS userProfile (
                    username TEXT PRIMARY KEY,
                    password TEXT NOT NULL,
                    email TEXT NOT NULL,
                    name TEXT NOT NULL
                    ) WITHOUT ROWID ;
                    """;
            s.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void CreateSubject() {
        try (Connection c = DatabaseManager.connect();
             Statement s = c.createStatement()) {
            String sql = """
                    CREATE TABLE IF NOT EXISTS subject (
                    courseName TEXT PRIMARY KEY,
                    studyGoal  NOT NULL,
                    subjectType TEXT NOT NULL,
                    difficultyLevel INTEGER NOT NULL,
                    username TEXT NOT NULL,
                    FOREIGN KEY (username) REFERENCES userProfile (username)
                    ) WITHOUT ROWID ;
                    """;
            s.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void CreateSubjectElement() {
        try (Connection c = DatabaseManager.connect();
             Statement s = c.createStatement()) {       /*(Το deadline σε μορφη YYYY-MM-DD HH:MM:SS)*/
            String sql = """
                    CREATE TABLE IF NOT EXISTS subjectElement (
                    name TEXT PRIMARY KEY,
                    deadline TEXT,
                    subjectName TEXT NOT NULL,
                    FOREIGN KEY (subjectName) REFERENCES subject (coursename)
                    ) WITHOUT ROWID ;
                    """;
            s.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void CreateAssignment() {
        try (Connection c = DatabaseManager.connect();
             Statement s = c.createStatement()) {
            String sql = """
                    CREATE TABLE IF NOT EXISTS assignment (
                    name TEXT NOT NULL,
                    status TEXT NOT NULL,
                    estHours REAL NOT NULL,
                    FOREIGN KEY (name) REFERENCES subjectElement (name)
                    );
                    """;
            s.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void CreateExam() {
        try (Connection c = DatabaseManager.connect();
             Statement s = c.createStatement()) {       /*(Το examDate σε μορφη YYYY-MM-DD HH:MM:SS)*/
            String sql = """
                    CREATE TABLE IF NOT EXISTS exam (
                    name TEXT NOT NULL,
                    courseName TEXT NOT NULL,
                    examDate TEXT,
                    studyHoursNeeded REAL NOT NULL,
                    modules INT NOT NULL,
                    pages INT NOT NULL,
                    FOREIGN KEY (name) REFERENCES subjectElement(name),
                    FOREIGN KEY (courseName) REFERENCES subject(courseName)
                    );
                    """;
            s.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void CreateWeek() {
        try (Connection c = DatabaseManager.connect();
             Statement s = c.createStatement()) {
            String sql = """
                    CREATE TABLE IF NOT EXISTS week (
                    weekNum INT NOT NULL UNIQUE,
                    totalWeeklyHours
                    );
                    """;
            s.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void CreateDay() {
        try (Connection c = DatabaseManager.connect();
             Statement s = c.createStatement()) {
            String sql = """
                    CREATE TABLE IF NOT EXISTS day (
                    name TEXT PRIMARY KEY,
                    status TEXT,
                    weekNum INT NOT NULL,
                    FOREIGN KEY (weekNum)
                    	REFERENCES week (weekNum)
                    ) WITHOUT ROWID ;
                    """;
            s.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void CreateAvailability() {
        try (Connection c = DatabaseManager.connect();
             Statement s = c.createStatement()) {
            String sql = """
                    CREATE TABLE IF NOT EXISTS availability (
                    hoursAvailable REAL NOT NULL,
                    hoursLeft REAL NOT NULL,
                    username TEXT NOT NULL,
                    day TEXT NOT NULL,
                    PRIMARY KEY (username, day),
                    FOREIGN KEY (username)
                    	REFERENCES userProfile (username),
                    FOREIGN KEY (day)
                    	REFERENCES day (name)
                    ) WITHOUT ROWID ;
                    """;
            s.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void CreateScheduledTask() {
        try (Connection c = DatabaseManager.connect();
             Statement s = c.createStatement()) {
            String sql = """
                    CREATE TABLE IF NOT EXISTS scheduledTask (
                    taskName TEXT PRIMARY KEY,
                    status TEXT NOT NULL,
                    hours REAL NOT NULL,
                    day TEXT NOT NULL,
                    FOREIGN KEY (day)
                    	REFERENCES day (name)
                    ) WITHOUT ROWID ;
                    """;
            s.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
