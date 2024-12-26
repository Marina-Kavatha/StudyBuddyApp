package org.javawavers.studybuddy;

import java.util.Random;

/*Providing a random number that represents the total hours required for revision
*The number is between 0 and 5 
*/
public class SpacedrepetitionAlgo {
    public static double spacedrepetition() {
        Random ran = new Random();
        return ran.nextDouble() * 5;
    }
}
