

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Repetition {

    /*
     * This method generates a schedule for repetitions based on the study task.
     * A repetition task is scheduled for:
     * - The next day after the study task.
     * - After 7 days.
     * - After 16 days.
     * - After 35 days.
     * - Then it doubles the interval days till the exam date.
     */
    public static List<Task> generateRepetitions(List<Task> tasks, Task studyTask, LocalDate examDate, int day) {

        List<RepetitionTask> repetitions = new ArrayList<>();

        // Get the date of the study task
        LocalDate studyDate = LocalDate.now().plusDays(day);
        String subject = studyTask.getSubject();

        // Add repetition for the next day
        LocalDate repetitionDate = studyDate.plusDays(1);
        repetitions.add(new RepetitionTask(subject, repetitionDate));

        // Add repetition after specific intervals
        int[] fixedIntervals = { 7, 16, 35 }; // Fixed intervals in days
        for (int f : fixedIntervals) {
            repetitionDate = studyDate.plusDays(f);
            if (repetitionDate.isBefore(examDate)) {
                repetitions.add(new RepetitionTask(subject, repetitionDate));
            }
        }

        // Add repetitions with doubling intervals until the exam date
        int interval = 35;
        while (true) {
            interval *= 2; // Double the interval
            repetitionDate = studyDate.plusDays(interval);
            if (repetitionDate.isBefore(examDate)) {
                repetitions.add(new RepetitionTask(subject, repetitionDate));
            } else {
                break; // Stop if the date exceeds the exam date
            }
        }

        // Add a repetition just before the exam date (if it fits)
        LocalDate preExamDate = examDate.minusDays(1);
        if (preExamDate.isAfter(studyDate)) {
            repetitions.add(new RepetitionTask(subject, preExamDate));
        }

        return assRepetitions(repetitions, tasks, subject);
    }

    // class that assigns the repetition tasks into the schedule
    public static List<Task> assRepetitions(List<RepetitionTask> rep, List<Task> tasks, String subject) {
        // Retrieve the current schedule
        int[][] schedule = SimulateAnnealing.getValSchedule();
        if (schedule == null) {
            throw new IllegalStateException(
                    "Schedule is not initialized.");
        }

        for (RepetitionTask r : rep) {
            LocalDate today = LocalDate.now();
            int daysBetween = (int) ChronoUnit.DAYS.between(today, r.getDate());

            if (daysBetween >= 0 && daysBetween < schedule[0].length) { // Ensure daysBetween is within bounds
                for (int i = 0; i < 12; i++) { // Iterate through rows (max 12 tasks per day)
                    // check for an unassigned slot and if the day is available
                    if (schedule[i][daysBetween] == 0 && Availability.checkAvailability(daysBetween)) {
                        // Add a new repetition task
                        tasks.add(new Task(subject, 2)); // 2 represents a repetition task
                        // Assign the task index to the schedule
                        schedule[i][daysBetween] = tasks.size() - 1;
                        break; // Exit loop after assigning the task
                    }
                }
            }
        }

        // Update the modified schedule
        SimulateAnnealing.setValSchedule(schedule);

        return tasks;
    }

    // Helper class to represent a repetition task
    public static class RepetitionTask {
        private String subject;
        private LocalDate date;

        public RepetitionTask(String subject, LocalDate date) {
            this.subject = subject;
            this.date = date;
        }

        public String getSubject() {
            return subject;
        }

        public LocalDate getDate() {
            return date;
        }
    }

}
/*
 * kalo;yme gia k;aue task typou 1 thh generateRepetitions ωστε να μου φτιάξει
 * στη λίστα με τα τασκς τασκς τύπου 2
 * η οποία επιστρέφει τη λίστα με τα τασκς επικαιροποιημένη μέσα σε αυτή τη
 * μέθοδο καλείται η assRepetitions
 * η οποία έχει προσβαση στον πίνακα valSchedule ο οποίος είναι τύπου protected
 */
/*
 * Για κάθε 2ωρο τασκ διαβάσματος αντιστοιχεί ένα 20λ επανάληψης
 * άρα 1 ώρα επανάληψης καλύπτει 3 τασκ διαβάσματος (του ιδιου ή
 * διαφορετικών μαθημάτων)
 * και πρέπει να έχω επαναληψη την επομένη μέρα, μετά από 7 μέρες,
 * μετα από 25 μερες και πριν την εξεταστική
 * καθένα απο αυτές τις επαναλήψεις ο χρόνος παραμένει 20λ
 */
