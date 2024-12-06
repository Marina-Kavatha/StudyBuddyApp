package org.javawavers.studybuddy;

import java.util.ArrayList;

public class ManageExam extends Manage {

    private ArrayList<String> exams;

    public ManageExam() {
        super("Exam"); // Αρχικοποίηση τύπου
        this.exams = new ArrayList<>();
    }

    // Προσθήκη εξέτασης
    @Override
    public void add(Object exam) {
        exams.add((String) exam);
        System.out.println("Προστέθηκε εξέταση: " + exam);
    }

    // Αφαίρεση εξέτασης
    @Override
    public void remove(Object exam) {
        if (exams.remove((String) exam)) {
            System.out.println("Αφαιρέθηκε εξέταση: " + exam);
        } else {
            System.out.println("Η εξέταση δεν βρέθηκε.");
        }
    }

    // Εμφάνιση όλων των εξετάσεων
    public void displayExams() {
        System.out.println("Λίστα εξετάσεων:");
        for (String exam : exams) {
            System.out.println("- " + exam);
        }
    }
}

