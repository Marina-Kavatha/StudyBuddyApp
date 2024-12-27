package org.javawavers.studybuddy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Subject {
    // Enum για τους τύπους μαθημάτων
    public enum SubjectType {
        THEORETICAL, PRACTICAL, BOTH, UNDEFINED
    }

    // Enum για τον στόχο μελέτης
    public enum StudyGoal {
        AVERAGE, GOOD, EXCELLENT
    }
    private static final Random random = new Random();
    private String courseName;
    private int difficultyLevel; // Επίπεδο δυσκολίας
    private SubjectType subjectType; // Τύπος μαθήματος
    private StudyGoal studyGoal; // Στόχος μελέτης
    private final List<Exam> exams = new ArrayList<>(); // Λίστα εξετάσεων
    private final List<Assignment> assignments = new ArrayList<>(); // Λίστα εργασιών
    private String color;//χρωμα που αντιπρωσοπευει το μαθημα

    // Getters και Setters
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
    // Κατασκευαστής με όρισμα μόνο το όνομα του μαθήματος
    public Subject(String courseName) {
        this.courseName = courseName;
        this.difficultyLevel = 1; // Προεπιλεγμένο επίπεδο δυσκολίας
        this.subjectType = SubjectType.UNDEFINED; // Προεπιλεγμένος τύπος μαθήματος
        this.studyGoal = StudyGoal.GOOD; // Προεπιλεγμένος στόχος μελέτης
        this.color = selectColor();
    }

    // Κατασκευαστής με όλα τα πεδία
    public Subject(String courseName, int difficultyLevel, SubjectType subjectType, StudyGoal studyGoal, String color) {
        this.courseName = courseName;
        this.difficultyLevel = difficultyLevel;
        this.subjectType = subjectType;
        this.studyGoal = studyGoal;
        this.color = selectColor();
    }

    // Μέθοδοι διαχείρισης εξετάσεων
    public void addExam(Exam exam) { //προσθήκη εξεταστικής
        exams.add(exam);
    }

    public List<Exam> getExams() { //μέθοδος για ανάκτηση εξετάσεων
        return exams;
    }

    // Μέθοδοι διαχείρισης εργασιών
    public void addAssignment(Assignment assignment) { //προσθήκη εργασίας
        assignments.add(assignment);
    }

    public List<Assignment> getAssignments() { //μέθοδος για ανάκτηση εργασιών
        return assignments;
    }

    public String getColor() {
        return AVAILABLE_COLORS[random.nextInt(AVAILABLE_COLORS.length)];
    }

    public void setColor(String color) {
        this.color = color;
    }

    private static final String[] AVAILABLE_COLORS = {"Red", "Blue", "Green", "Yellow", "Purple", "Orange"};
    private static final List<String> usedColors = new ArrayList<>(); //λιστα απο τα χρωματα που εχουν χρησιμοποιηθει

    private String selectColor() {
        for (String availableColor : AVAILABLE_COLORS) {
            if (!usedColors.contains(availableColor)) {
                usedColors.add(availableColor);
                return availableColor;
            }
        }
        return "No Color Available"; //αν δεν υπααρχουν διαθεσιμα χρωματα
    }

}
