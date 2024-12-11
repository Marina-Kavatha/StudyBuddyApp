
/* This class is used to assign a score to each valid result
 * that could be used as a recommended study schedule for the user.
 * The SimulateAnnealing class produces 50 valid results.
 * Validity means that the tasks are distributed according to the user's
 * daily availability for studying.
 * Each result is then given a score to determine the most effective one
 * among those that are randomly produced.
 * The maximum score a valid result can achieve is 5.0.
 * -0.2 points are deducted each time the same task type (1-studying,
 * 2-revision, 3-assignment) for the same subject is assigned on the same day.
 * -0.1 points are deducted when a subject is studied two days in a row.
 */

import java.util.ArrayList;
import java.util.List;

public class Scoring {
    public static double calculatescore(List<Task> taskList, int[][] sch) {
        // set the score at 5.0. The higher that can possibly be achieved
        double score = 5.0;
        // creating a list that should contain each subject only once
        List<SubjectTest> uniqueS = new ArrayList<>();
        for (Task task : taskList) {
            SubjectTest subject = task.getSubject();
            if (!uniqueS.contains(subject)) {
                uniqueS.add(subject); // Προσθήκη του μαθήματος αν δεν υπάρχει ήδη
            }
        }

        // -0.2 penalty for the same task type for the same subject on the same day
        // for each day
        for (int day = 1; day < 8; day++) {

            // for each individual subject
            for (int index = 0; index < uniqueS.size(); index++) {
                SubjectTest usubject = uniqueS.get(index);
                // we check if there is also a same task
                for (int row = 0; row < 12; row++) {
                    if (sch[row][day] != 0 && sch[row][day] < taskList.size()) {
                        Task t = taskList.get(sch[row][day]);

                        /*
                         * checks if the subject from the subject list is the same as
                         * the one from the task list
                         */
                        if (usubject.getName() == t.getSubject().getName()) {
                            score -= 0.2;
                        }

                    } else {
                        break;
                    }
                }

            }
        }

        // -0.1 penalty for studying the same subject two days in a row
        return score;
    }
}
