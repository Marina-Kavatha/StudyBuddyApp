package org.javawavers.studybuddy;

import java.time.LocalDate;

public class SubjectTest {
    private String name;
    private double difficultyrange;
    private int totalpagenumber;
    private LocalDate examDate;
    private String color;

    // sets the name the difficulty range the total number an the exam date
    public SubjectTest(String n, double d, int t, LocalDate e, String color) {
        this.name = n;
        this.difficultyrange = d;
        this.totalpagenumber = t;
        this.examDate = e;
        this.color = color;
    }

    public int getTotalpagenumber() {
        return totalpagenumber;
    }

    public double getDifficultyrange() {
        return difficultyrange;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
