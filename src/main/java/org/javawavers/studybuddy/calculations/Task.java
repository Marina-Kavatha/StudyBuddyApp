package org.javawavers.studybuddy.calculations;


public class Task {
    private String subjName;
    private int taskType; // 1: Studying , 2: revision, 3: assignment

    // constructor with the Subject object
    public Task(Subject subj, int taskType) {
        subjName = subj.getCourseName();
        this.taskType = taskType;
    }

    // constructor with the subject as a String
    public Task(String subj, int taskType) {
        subjName = subj;
        this.taskType = taskType;
    }

    // get subject's name
    public String getSubject() {
        return subjName;
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
        return subjName + " - " + type;
    }
}
