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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimulateAnnealing {
    /*
     * The 12 rows represent the maximum tasks that can be assigned to a day,
     * which are 12 tasks of a duration of two hours each. The 8 columns represent
     * the 7 days of the week, starting with Monday. The first column of the table
     * is not used to prevent misinterpretation by the table pointer
     * with a value of zero.
     */

    private List<SubjectTest> subjects; // List for subjects
    private List<Task> tasks; // List for each task that is connected with a subject

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
    private static List<Task> besttask = new ArrayList<>();;

    // Κατανομή tasks στο πρόγραμμα
    public static List<Task> SchedulResult(List<Task> tasks) {
        /*
         * each time the method is called in order to produce the best result
         * the best scoring is set as zero and the list with the best distribution,
         * shuffles an arrey so that the order of the table elements
         * differents from the one that is given
         * The procidure is done 10 times in order to produce 10 possible results
         * Then each list gets a score. The list with the higher score is set as the
         * besttask
         */
        bestscoring = 0.0;
        besttask.clear();

        for (int i = 0; i < 10; i++) {
            double valresultscoring = 0.0;
            Collections.shuffle(tasks); // Ανακάτεμα tasks για τυχαία κατανομή
            // indicates the possision of the task taht is located in the tasks list

            // list scoring
            valresultscoring = setScore(tasks);
            bestschedule(valresultscoring, tasks);
        }
        return besttask;

    }

    // calls static method calculatescore
    public static double setScore(List<Task> taskList) {
        double score = 0.5;
        return score;
    }

    public static void bestschedule(double valresultscoring, List<Task> taskList) {
        if (valresultscoring > bestscoring) {
            bestscoring = valresultscoring;
            besttask = taskList;
        }
    }

    // trial

    public static Map<Integer, List<Task>> assignTasks(List<Task> tasks) {
        Map<Integer, List<Task>> schedule = new HashMap<>(); // Χάρτης: ημέρα -> λίστα tasks
        for (int i = 1; i <= 7; i++) {
            schedule.put(i, new ArrayList<>()); // Αρχικοποίηση για κάθε ημέρα
        }

        for (Task task : tasks) {
            boolean assigned = false;

            for (int day = 1; day <= 7; day++) {
                if (Availability.getTotalAvailableHours(day) >= 2 && Availability.availabilityLeft(day, 0) == 1) {
                    schedule.get(day).add(task); // Ανάθεση task στην ημέρα
                    Availability.availabilityLeft(day, 1); // Μείωση διαθέσιμων ωρών
                    assigned = true;
                    break;
                }
            }

            if (!assigned) {
                System.out.println("Το task δεν μπορεί να ανατεθεί λόγω έλλειψης διαθεσιμότητας: " + task);
            }
        }

        return schedule;
    }
}
