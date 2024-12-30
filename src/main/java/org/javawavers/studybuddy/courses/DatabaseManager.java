package org.javawavers.studybuddy.courses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseManager {
    private static final String DATABASE_URL = "jdbc:sqlite:C:\\Users\\ioann\\IdeaProjects\\practiceJavaFx\\src\\main\\resources\\dataBase.db";

    public static Connection connect() {
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            return connection;
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
        try (Connection c = DataBaseManager.connect();
             Statement s = c.createStatement()) {
            String sql = """
                    CREATE TABLE IF NOT EXISTS User (
                    name TEXT PRIMARY KEY,
                    username TEXT NOT NULL,
                    password TEXT NOT NULL,
                    email TEXT NOT NULL
                    ) WITHOUT ROWID ;
                    """;
            s.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void CreateSubject() {
        try (Connection c = DataBaseManager.connect();
             Statement s = c.createStatement()) {
            String sql = """
                    CREATE TABLE IF NOT EXISTS subject (
                    subjectName TEXT PRIMARY KEY,
                    difficultyLevel INTEGER NOT NULL,
                    subjectType TEXT NOT NULL,
                    studyGoal NOT NULL,
                    username TEXT NOT NULL,
                    FOREIGN KEY (username) REFERENCES User (username)
                    ) WITHOUT ROWID ;
                    """;
            s.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void CreateAssignment() {    // convert LocalDate deadline and completeddDate to String
        try (Connection c = DataBaseManager.connect();
             Statement s = c.createStatement()) {
            String sql = """
                    CREATE TABLE IF NOT EXISTS Assignment (
                    title TEXT PRIMARY KEY,
                    subjectName TEXT NOT NULL,
                    remainingDays INTEGER NOT NULL,
                    deadline TEXT NOT NULL,
                    estimateHours INTEGER NOT NULL,
                    completeddDate TEXT NOT NULL,
                    name TEXT NOT NULL,
                    FOREIGN KEY (subjectName) REFERENCES subject(subjectName)
                    );
                    """;
            s.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void CreateExam() {
        try (Connection c = DataBaseManager.connect();
             Statement s = c.createStatement()) { //

            String sql = """
                    CREATE TABLE IF NOT EXISTS Exam (
                    name TEXT PRIMARY KEY,
                    subjectName TEXT NOT NULL,
                    deadline TEXT NOT NULL,
                    pages INT NOT NULL,
                    revisionPerXPages INT NOT NULL,
                    minutesPer20Slides REAL NOT NULL,
                    FOREIGN KEY (subjectName) REFERENCES subject(subjectName)
                    );
                    """;
            s.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void CreateWeek() {
        try (Connection c = DataBaseManager.connect();
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
        try (Connection c = DataBaseManager.connect();
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
        try (Connection c = DataBaseManager.connect();
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
        try (Connection c = DataBaseManager.connect();
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

