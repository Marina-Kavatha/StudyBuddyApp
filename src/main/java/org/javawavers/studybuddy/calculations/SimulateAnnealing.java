package org.javawavers.studybuddy.calculations;/*
 /*
 * This class distributes three kinds of tasks (studying -1, repetition -2,
 * assignment -3) into the available days randomly. The algorithm produces 10
 *  valid results,where the tasks are distributed into the available studying
 * hours per day differently (although there are chances for the same results).
 * Then, each result gains a score based on certain criteria, described in the
 * README file. The result with the higher score is considered the final result
 * and is given to the user as a recommended studying schedule.
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.javawavers.studybuddy.availability.*;
public class SimulateAnnealing {
    /*
     * The 12 rows represent the maximum tasks that can be assigned to a day,
     * which are 12 tasks of a duration of two hours each. The 8 columns represent
     * the 7 days of the week, starting with Monday. The first column of the table
     * is not used to prevent misinterpretation by the table pointer
     * with a value of zero.
     */

    private static List<Subject> subjects; // List for subjects
    private static List<Task> tasks; // List for each task that is connected with a subject
    private static List<ExamDates> exams; // List for each exam that is connected with a subject

    public SimulateAnnealing() {
        this.subjects = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.exams = new ArrayList<>();
    }

    // Public getter for the tasks list
    public List<Task> getTasks() {
        // Return a copy of the tasks list to maintain encapsulation
        return new ArrayList<>(this.tasks);
    }

    // Add a new Subject
    public void addSubject(Subject subject) {
        subjects.add(subject);
        // Sets exams for the subject
        subExams(subject);

        // Creates tasks for the subject
        subTasks(subject);

    }

    // Setting exams for each subject
    private void subExams(Subject subject) {

        // Create an ExamDates object with the subject name and the exam date
        ExamDates examDate = new ExamDates(subject, subject.getExams().get(0).getExamDate());
        // Add the ExamDates object to the list
        exams.add(examDate);

    }

    // Creating tasks for each subject
    private void subTasks(Subject subject) {
        // studying tasks
        int taskType1 = CalculativeAlgorithm.studyingPerweek(subject);
        // assignment tasks
        int taskType3 = CalculativeAlgorithm.numberOfScheduledTask(subject.getTotalAssHours());

        // Task creation for each task type
        for (int i = 0; i < taskType1; i++) {
            tasks.add(new Task(subject, 1)); // studying
        }

        for (int i = 0; i < taskType3; i++) {
            tasks.add(new Task(subject, 3)); // Assignment
        }
    }

    private static double bestscoring;
    private static List<Task> besttask = new ArrayList<>();
    private static int[][] schedule;
    // The column size of the table is determined by the last examination date
    private static int colsize = 0;

    // Κατανομή tasks στο πρόγραμμα
    public static void SchedulResult() {
        /*
         * each time the method is called in order to produce the best result
         * the best scoring is set as zero and the list with the best distribution,
         * shuffles an array so that the order of the table elements
         * differents from the one that is given
         * The procidure is done 50 times in order to produce 10 possible results
         * Then each list gets a score. The list with the higher score is set as the
         * besttask
         */
        bestscoring = 0.0;
        besttask.clear();

        // sort exams
        exams = ExamDates.sortExam(exams);
        // The column size of the table is determined by the last examination date
        colsize = ExamDates.lastExIsDue(exams);

        // EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
        for (int i = 0; i < 1; i++) {

            double valresultscoring = 0.0;

            schedule = assignTask(tasks);

            // list scoring
            valresultscoring = setScore(tasks, schedule);
            if (i == 0) {
                bestscoring = valresultscoring;
            }

            bestschedule(valresultscoring, tasks, schedule);
        }
        PrintSchedule.printSchedule(schedule, besttask, colsize);

    }

    // calls static method calculatescore
    public static double setScore(List<Task> taskList, int[][] sch) {
        return Scoring.calculatescore(taskList, sch, colsize);
    }

    public static void bestschedule(double valresultscoring, List<Task> taskList, int[][] sch) {
        if (valresultscoring >= bestscoring) {
            bestscoring = valresultscoring;
            besttask = taskList;
            schedule = sch;
        }
    }

    private static int[][] valSchedule;

    public static void setValSchedule(int[][] sc) {
        valSchedule = sc;
    }

    public static int[][] getValSchedule() {
        return valSchedule;
    }

    public static int[][] assignTask(List<Task> tasks) {
        Collections.shuffle(tasks);
        /*
         * The table valSchedule stors the index of the task Array list, after the
         * tasks have been distributed into the available hours
         */
        if (colsize == 0) {
            throw new IllegalStateException(
                    "Column size is not initialized. Ensure exams are sorted and colsize is set.");
        }

        int[][] valSchedule = new int[12][colsize];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < colsize; j++) {
                valSchedule[i][j] = 0;
            }
        }

        // Index of the tasks Array List
        int taskIndex = 1;
        System.out
                .println(" SSSSSSSSSSSSSSSS" + tasks.get(taskIndex).getTaskType() + tasks.get(taskIndex).getSubject());
        System.out.println("SSSSSSSSSSSSSSSSS" + tasks.get(1).getTaskType() + tasks.get(1).getSubject());
        // available hours for the day
        for (int col = 0; col < colsize; col++) {
            int remainingHours = Availability.getTotalAvailableHours(col);

            // check non Availability for a day
            boolean flagNAv;
            flagNAv = Availability.checkAvailability(col);

            if (flagNAv) {

                for (int row = 0; row < 12; row++) { // Max 12 tasks per day
                    // the loop ends when every task is assigned to a day
                    if (taskIndex >= tasks.size()) {
                        break;
                    }

                    if (remainingHours >= 2) { // each task requires 2 hours
                        /*
                         * check if the exam date of the subject's task that we want to
                         * assigne to a day has passed
                         */
                        boolean flagEx = false;

                        flagEx = ExamDates.checkExamDate(tasks.get(taskIndex), col, exams);
                        LocalDate exDate = ExamDates.getExDate(tasks.get(taskIndex), col, exams);

                        if (flagEx) {
                            tasks = Repetition.generateRepetitions(tasks, tasks.get(taskIndex), exDate, col);
                            // store the task index
                            valSchedule[row][col] = taskIndex;
                            // The remaining hours is reduced by 2 hours
                            remainingHours -= 2;
                            taskIndex++;
                        } else {
                            // continue to the next task
                            taskIndex++;
                        }
                    } else {
                        // if there are not enough available hours we continue to the next day
                        break;
                    }
                }
            }
        }

        // return the table with the valid result
        return valSchedule;
    }
}
