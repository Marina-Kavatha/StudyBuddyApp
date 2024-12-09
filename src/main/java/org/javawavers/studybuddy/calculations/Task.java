public class Task {
    private SubjectTest subject;
    private int taskType; // 1: διάβασμα, 2: επανάληψη, 3: εργασία

    // constructor
    public Task(SubjectTest subject, int taskType) {
        this.subject = subject;
        this.taskType = taskType;
    }

    // get subject's name
    public SubjectTest getSubject() {
        return subject;
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
        return subject.getName() + " - " + type;
    }
}
