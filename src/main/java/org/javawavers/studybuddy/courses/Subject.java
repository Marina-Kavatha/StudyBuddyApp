package org.javawavers.studybuddy.courses;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    // Enum for the Subject Type
    public enum SubjectType {
        THEORETICAL, PRACTICAL, BOTH, UNDEFINED
    }

    // Enum for Studying Goal
    public enum StudyGoal {
        AVERAGE, GOOD, EXCELLENT
    }

    private String courseName;
    private int difficultyLevel; // difficulty Level
    private SubjectType subjectType; // subject Type 
    private StudyGoal studyGoal; // Study Goal 
    private static List<Exam> exams = new ArrayList<>(); // Exam List
    private static List<Assignment> assignments = new ArrayList<>(); // Assignment List

    // Getters and Setters
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public StudyGoal getStudyGoal() {
        return studyGoal;
    }

    public void setStudyGoal(StudyGoal studyGoal) {
        this.studyGoal = studyGoal;
    }

    // Constructors
    //Constructor only for the name of the Subject
    public Subject(String courseName) {
        this.courseName = courseName;
        this.difficultyLevel = 1; // Default difficulty Level
        this.subjectType = SubjectType.UNDEFINED; //Default subject type 
        this.studyGoal = StudyGoal.GOOD; // Default studying goal 
    }

    // Constructor with all the fields 
    public Subject(String courseName, int difficultyLevel, SubjectType subjectType, StudyGoal studyGoal) {
        this.courseName = courseName;
        this.difficultyLevel = difficultyLevel;
        this.subjectType = subjectType;
        this.studyGoal = studyGoal;
    }

    // Exam management methods
    public static void addExam(Exam exam) { //Exam addition
        exams.add(exam);
    }

    public static List<Exam> getExams() { //Method for Exam recovery
        return exams;
    }

    // Assignments management methods
    public static void addAssignment(Assignment assignment) { //assignment addition
        assignments.add(assignment);
    }

    public static List<Assignment> getAssignments() { //Method for assignment recovery
        return assignments;
    }

    public double getTotalAssHours() {
        double sum = 0.0;

        // Traverse through the assignments list
        for (Assignment assignment : assignments) {
            sum += assignment.getEstimateHours(); // Add the estimated hours of the current assignment
        }

        return sum;
    }
}
