/*
 * This class distributes three kinds of tasks (studying -1, repetition -2,
 * assignment -3) into the available days randomly. The algorithm produces 10
 *  valid results,where the tasks are distributed into the available studying
 * hours per day differently (although there are chances for the same results).
 * Then, each result gains a score based on certain criteria, described in the
 * README file. The result with the higher score is considered the final result
 * and is given to the user as a recommended studying schedule.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimulateAnnealing {
    /*
     * The 12 rows represent the maximum tasks that can be assigned to a day,
     * which are 12 tasks of a duration of two hours each. The 8 columns represent
     * the 7 days of the week, starting with Monday. The first column of the table
     * is not used to prevent misinterpretation by the table pointer
     * with a value of zero.
     */

    private List<SubjectTest> subjects; // List for subjects
    private static List<Task> tasks; // List for each task that is connected with a subject

    public SimulateAnnealing() {
        this.subjects = new ArrayList<>();
        this.tasks = new ArrayList<>();
    }

    // Public getter for the tasks list
    public List<Task> getTasks() {
        // Return a copy of the tasks list to maintain encapsulation
        return new ArrayList<>(this.tasks);
    }

    // Add a new Subject
    public void addSubject(SubjectTest subject) {
        subjects.add(subject);
        SubTasks(subject); // Δημιουργία tasks για το μάθημα
    }

    // Creating tasks for each subject
    private void SubTasks(SubjectTest subject) {
        // studying tasks
        int taskType1 = CalculativeAlgorithm.studyingPerweek(subject);
        // revision tasks
        int taskType2 = CalculativeAlgorithm.numberOfScheduledTask(SpacedrepetitionAlgo.spacedrepetition());
        // assignment tasks
        int taskType3 = CalculativeAlgorithm.numberOfScheduledTask(AssignmentTestaAlgo.getTotalAssignmentHours());

        // Δημιουργούμε tasks για κάθε τύπο
        for (int i = 0; i < taskType1; i++) {
            tasks.add(new Task(subject, 1)); // Διάβασμα
        }
        for (int i = 0; i < taskType2; i++) {
            tasks.add(new Task(subject, 2)); // Επανάληψη
        }
        for (int i = 0; i < taskType3; i++) {
            tasks.add(new Task(subject, 3)); // Εργασία
        }
    }

    private static double bestscoring = 0.0;
    private static List<Task> besttask = new ArrayList<>();
    private static int[][] schedule;

    // Κατανομή tasks στο πρόγραμμα
    public static void SchedulResult() {
        /*
         * each time the method is called in order to produce the best result
         * the best scoring is set as zero and the list with the best distribution,
         * shuffles an arrey so that the order of the table elements
         * differents from the one that is given
         * The procidure is done 50 times in order to produce 10 possible results
         * Then each list gets a score. The list with the higher score is set as the
         * besttask
         */
        bestscoring = 0.0;
        besttask.clear();
        for (int i = 0; i < 50; i++) {
            double valresultscoring = 0.0;

            schedule = assignTask(tasks);
            // list scoring
            valresultscoring = setScore(tasks, schedule);
            bestschedule(valresultscoring, tasks, schedule);
        }
        printSchedule();

    }

    // calls static method calculatescore
    public static double setScore(List<Task> taskList, int[][] sch) {
        return Scoring.calculatescore(taskList, sch);
    }

    public static void bestschedule(double valresultscoring, List<Task> taskList, int[][] sch) {
        if (valresultscoring > bestscoring) {
            bestscoring = valresultscoring;
            besttask = taskList;
            schedule = sch;
        }
    }

    public static int[][] assignTask(List<Task> tasks) {
        Collections.shuffle(tasks);
        /*
         * The table valSchedule stors the index of the task Array list, after the
         * tasks have been distributed into the available hours
         */
        int[][] valSchedule = new int[12][8];
        // Index of the tasks Array List
        int taskIndex = 0;

        for (int day = 1; day <= 7; day++) { // for each day of the week
            // available hours for the day
            int remainingHours = Availability.getTotalAvailableHours(day);

            for (int row = 0; row < 12; row++) { // Max 12 tasks per day
                // the loop ends when every task is assigned to a day
                if (taskIndex >= tasks.size()) {
                    break;
                }
                if (remainingHours >= 2) { // each task requirs 2 hours
                    // stor the task index (taskIndex +1 because we begin with 0)
                    valSchedule[row][day] = taskIndex + 1;
                    // The remaining hours is reduced by 2 hours
                    remainingHours -= 2;
                    taskIndex++;
                } else {
                    // if there are not enough available hours we continue to the next day
                    break;
                }
            }
        }
        // return the table with the valid result
        return valSchedule;
    }

    // The below method prints the schedule too the user
    public static void printSchedule() {
        System.out.println("Προτεινόμενο πρόγραμμα");
        for (int i = 1; i < 8; i++) {
            System.out.println("Μέρα:" + i);
            for (int j = 0; j < 12; j++) {

                if (schedule[j][i] > 0) {
                    System.out.println(besttask.get(i));
                } else {
                    continue;
                }
            }

        }
    }

}
