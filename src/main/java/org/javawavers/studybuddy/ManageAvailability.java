package org.javawavers.studybuddy;

import java.util.ArrayList;

public class ManageAvailability {
    private ArrayList<String> availability;

    public ManageAvailability() {
        this.availability = new ArrayList<>();
    }

    // Προσθήκη διαθεσιμότητας
    public void add(String availabilityEntry) {
        availability.add(availabilityEntry);
        System.out.println("Προστέθηκε διαθεσιμότητα: " + availabilityEntry);
    }

    // Αφαίρεση διαθεσιμότητας
    public void remove(String availabilityEntry) {
        if (availability.remove(availabilityEntry)) {
            System.out.println("Αφαιρέθηκε διαθεσιμότητα: " + availabilityEntry);
        } else {
            System.out.println("Η διαθεσιμότητα δεν βρέθηκε.");
        }
    }

    // Εμφάνιση διαθεσιμότητας
    public void displayAvailability() {
        System.out.println("Λίστα διαθεσιμότητας:");
        for (String entry : availability) {
            System.out.println("- " + entry);
        }
    }
}

