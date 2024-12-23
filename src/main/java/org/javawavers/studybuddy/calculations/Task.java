package org.javawavers.studybuddy.calculations;

public class Task {
    private Subject subj;
    private int taskType; // 1: διάβασμα, 2: επανάληψη, 3: εργασία

    // constructor
    public Task(Subject subj, int taskType) {
        this.subj = subj;
        this.taskType = taskType;
    }

    // get subject's name
    public Subject getSubject() {
        return subj;
    }

    // get task's type
    public int getTaskType() {
        return taskType;
    }

    @Override
    public String toString() {
        String type;
        if (taskType == 1) {
            type = "Διάβασμα";
        } else if (taskType == 2) {
            type = "Επανάληψη";
        } else {
            type = "Εργασία";
        }
        return subj.getCourseName() + " - " + type;
    }
}
