package org.javawavers.studybuddy.utility;

import java.util.ArrayList;

public class UserProfile {
    
    private String name;
    private String username;
    private String email;
    private String password;
    private ArrayList<String> enrolledCourses;

    // Κατασκευαστής για αρχικοποίηση
    public UserProfile(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.enrolledCourses = new ArrayList<>();
    }

    // Μέθοδος για εγγραφή σε μάθημα
    public void enrollInCourse(String courseName) {
        enrolledCourses.add(courseName);
        System.out.println("Εγγραφή στο μάθημα: " + courseName + " επιτυχής.");
    }

    // Μέθοδος για ακύρωση εγγραφής από μάθημα
    public void dropCourse(String courseName) {
        if (enrolledCourses.remove(courseName)) {
            System.out.println("Ακύρωση εγγραφής από το μάθημα: " + courseName);
        } else {
            System.out.println("Το μάθημα " + courseName + " δεν βρέθηκε στη λίστα.");
        }
    }

    // Μέθοδος για εμφάνιση των μαθημάτων του χρήστη
    public void displayEnrolledCourses() {
        System.out.println("Μαθήματα χρήστη:");
        for (String course : enrolledCourses) {
            System.out.println("- " + course);
        }
    }
}

