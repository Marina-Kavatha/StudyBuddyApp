package org.javawavers.studybuddy;

import java.util.ArrayList;

public class ManageSubject extends Manage {

    private ArrayList<String> subjects;

    public ManageSubject() {
        super("Subject");
        this.subjects = new ArrayList<>();
    }

    // Προσθήκη μαθήματος
    @Override
    public void add(Object subject) {
        subjects.add((String) subject);
        System.out.println("Προστέθηκε μάθημα: " + subject);
    }

    // Αφαίρεση μαθήματος
    @Override
    public void remove(Object subject) {
        if (subjects.remove((String) subject)) {
            System.out.println("Αφαιρέθηκε μάθημα: " + subject);
        } else {
            System.out.println("Το μάθημα δεν βρέθηκε.");
        }
    }

    // Εμφάνιση όλων των μαθημάτων
    public void displaySubjects() {
        System.out.println("Λίστα μαθημάτων:");
        for (String subject : subjects) {
            System.out.println("- " + subject);
        }
    }
}

