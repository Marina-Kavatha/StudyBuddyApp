package org.javawavers.studybuddy.calculations;

import java.time.LocalDate;

public class MainTestAlgorithm {
    public static void main(String[] args) {
        // Initialize Availability (example)
        Availability.setAvailability(1, 6); // Monday: 6 available hours
        Availability.setAvailability(2, 4); // Tuesday: 4 available hours
        Availability.setAvailability(3, 7); // Wednesday: 5 available hours
        Availability.setAvailability(4, 4); // Thursday: 3 available hours
        Availability.setAvailability(5, 6); // Friday: 6 available hours
        Availability.setAvailability(6, 6); // Saturday: 2 available hours
        Availability.setAvailability(7, 6); // Sunday: 1 available hour

        // Create subjects (example)
        SubjectTest math = new SubjectTest("Maths", 2.5, 600, LocalDate.now().plusDays(65));
        SubjectTest history = new SubjectTest("History", 1.8, 680, LocalDate.now().plusDays(65));

        // Add subjects to SimulateAnnealing
        SimulateAnnealing simulateAnnealing = new SimulateAnnealing();
        simulateAnnealing.addSubject(math);
        simulateAnnealing.addSubject(history);

        SimulateAnnealing.SchedulResult();
    }
}
