package org.javawavers.studybuddy.utility;

import java.util.ArrayList;

// Υπεύθυνη για τη διαχείριση χρηστών
public class ManageUser extends Manage {

    private ArrayList<String> users;

    public ManageUser() {
        super("User");
        this.users = new ArrayList<>();
    }

    // Προσθήκη χρήστη
    @Override
    public void add(Object user) {
        users.add((String) user);
        System.out.println("Προστέθηκε χρήστης: " + user);
    }

    // Αφαίρεση χρήστη
    @Override
    public void remove(Object user) {
        if (users.remove((String) user)) {
            System.out.println("Αφαιρέθηκε χρήστης: " + user);
        } else {
            System.out.println("Ο χρήστης δεν βρέθηκε.");
        }
    }

    // Εμφάνιση όλων των χρηστών
    public void displayUsers() {
        System.out.println("Λίστα χρηστών:");
        for (String user : users) {
            System.out.println("- " + user);
        }
    }
}

