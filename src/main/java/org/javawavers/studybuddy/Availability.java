package org.javawavers.studybuddy;
import java.time.LocalDate;
import java.util.LinkedList;

public class Availability {
    /*
     * A table for the available studying time for each day of the week
     * The first element of the table is never used.
     * Each number from 1 to 7 represents a day of the week starting with Monday
     */
    private static int[] avperday = new int[8];

    public static void availabilityPopupdia() {
        Popupdia popup = new Popupdia();
        avperday = popup.getAvailability();
    }
    

    /*
     * Gives the ability to the user to insert certain dates that there
     * is no available time for studying
     */
    private static LinkedList<LocalDate> dates = new LinkedList<>();

    // constructor
    public Availability() {

    }

    /*
     * setting the availability per day of the week
     */
    public static void setAvailability(int i, int av) {
        if (i <= 0 || i > 7) {
            throw new IllegalArgumentException(" Ο αριθμός πρέπει να είναι μεταξύ του 1και του 7");
        }
        avperday[i] = av;
    }

    // insert a day that there is no availability for studying
    public static void setNonAvailability(LocalDate l) {
        // checks if a date is already used
        if (!dates.contains(l)) {
            dates.add(l);
        } else {
            // if the date is already used, a message is given to the user
            System.out.println("Η ημερομηνία " + l + " έχει ήδη καταχωρηθεί");
        }

    }

    /*
     * checks if the day that the program asserts a task to the user is set as non
     * available
     * and returns true if it is
     */

    public static boolean checkAvailability(LocalDate l) {
        return dates.contains(l);
    }

    // returns the total available hours for the day that is asked
    public static int getTotalAvailableHours(int i) {
        if (i <= 0 || i > 7) {
            throw new IllegalArgumentException(" Ο αριθμός πρέπει να είναι μεταξύ του 1και του 7");
        }
        return avperday[i];

    }

    /*
     * Calculates the remaining study time left for a day.
     * Takes as input the day number, the repetition number :
     * 0 represents the first time the method is called,
     * -1 indicates that the task cannot be assigned to that day due to time
     * limitations, and
     * 1 indicates that the task has been successfully assigned for the day.
     */

    private static int remainghours; // saves the remaining available hours

    public static int availabilityLeft(int i, int j) {
        if (j == 0) {
            // sets the remaining hours for studying equal to the available hours
            remainghours = getTotalAvailableHours(i);
            // every scheduled task has a duration of two hours
            if (remainghours >= 2) {
                remainghours = remainghours - 2;
                return 1;
            } else {
                return -1;
            }

        } else {
            if (remainghours >= 2) {
                remainghours = remainghours - 2;
                return 1;
            } else {
                return -1;
            }
        }

    }
}
