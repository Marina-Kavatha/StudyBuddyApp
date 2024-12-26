package org.javawavers.studybuddy;

public class Task {
    private SubjectTest subj;
    private int taskType; // 1: διάβασμα, 2: επανάληψη, 3: εργασία

    // constructor
    public Task(SubjectTest subj, int taskType) {
        this.subj = subj;
        this.taskType = taskType;
    }

    // get subject's name
    public SubjectTest getSubject() {
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
        return subj.getName() + " - " + type;
    }
}
