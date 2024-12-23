package org.javawavers.studybuddy.calculations;

import java.util.Random;

//Simulates the time needed to complete an assignment
//Originaly that time is given by the user
public class AssignmentTestaAlgo {
    // Creates an object type Random for the production of random numbers
    private static Random ran = new Random();

    // returns the total time calculated in hours that is required for an assignment
    public static double getTotalAssignmentHours() {
        // produces a random number between 0 and 10
        return ran.nextDouble() * 10;
    }
}
