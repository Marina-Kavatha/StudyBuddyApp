package org.javawavers.studybuddy;

import java.util.ArrayList;

public class ManageAssignment extends Manage {

    private ArrayList<String> assignments;

    public ManageAssignment() {
        super("Assignment");
        this.assignments = new ArrayList<>();
    }

    // Προσθήκη εργασίας
    @Override
    public void add(Object assignment) {
        assignments.add((String) assignment);
        System.out.println("Προστέθηκε εργασία: " + assignment);
    }

    // Αφαίρεση εργασίας
    @Override
    public void remove(Object assignment) {
        if (assignments.remove((String) assignment)) {
            System.out.println("Αφαιρέθηκε εργασία: " + assignment);
        } else {
            System.out.println("Η εργασία δεν βρέθηκε.");
        }
    }

    // Εμφάνιση όλων των εργασιών
    public void displayAssignments() {
        System.out.println("Λίστα εργασιών:");
        for (String assignment : assignments) {
            System.out.println("- " + assignment);
        }
    }
}

