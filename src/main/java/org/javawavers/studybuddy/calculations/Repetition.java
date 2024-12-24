// This class controls the repetition tasks
// Every 3 study tasks (type 1), there is one task for revision

public class Repetition {
    public static int calculateRep(int task1) {
        /*
         * If the number of type 1 tasks is exactly divisible by 3,
         * then the number of repetition tasks is task1 / 3
         */
        if (task1 % 3 == 0) {
            return task1 / 3;
        } else {
            // Otherwise, we add 1 to ensure that we have a repetition task for the
            // remaining tasks
            return task1 / 3 + 1;
        }
    }
}
