import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class MainTestAlgorithm {
    public static void main(String[] args) {
        // Initialize Availability (example)
        Availability.setAvailability(1, 6); // Monday: 6 available hours
        Availability.setAvailability(2, 4); // Tuesday: 4 available hours
        Availability.setAvailability(3, 5); // Wednesday: 5 available hours
        Availability.setAvailability(4, 3); // Thursday: 3 available hours
        Availability.setAvailability(5, 6); // Friday: 6 available hours
        Availability.setAvailability(6, 2); // Saturday: 2 available hours
        Availability.setAvailability(7, 1); // Sunday: 1 available hour

        // Create subjects (example)
        SubjectTest math = new SubjectTest("Mathematics", 2.5, 500, LocalDate.now().plusDays(10)); // 100 pages,
                                                                                                   // difficulty 2.5,
                                                                                                   // exam in 10 days
        SubjectTest history = new SubjectTest("History", 1.8, 680, LocalDate.now().plusDays(15)); // 80 pages,
                                                                                                  // difficulty
                                                                                                  // 1.8, exam in 15
                                                                                                  // days

        // Add subjects to SimulateAnnealing
        SimulateAnnealing simulateAnnealing = new SimulateAnnealing();
        simulateAnnealing.addSubject(math);
        simulateAnnealing.addSubject(history);

        // Generate all tasks based on the subjects
        List<Task> allTasks = simulateAnnealing.getTasks();

        // Use assignTasksToDays to assign tasks to the days of the week
        Map<Integer, List<Task>> schedule = SimulateAnnealing.assignTasks(allTasks);

        // Print the schedule for each day
        for (int day = 1; day <= 7; day++) {
            System.out.println("Day " + day + ":"); // Print the day number (1 to 7)
            List<Task> tasksForDay = schedule.get(day); // Get the tasks for that day

            if (tasksForDay.isEmpty()) {
                System.out.println("  - No tasks for this day"); // If no tasks are assigned, show a message
            } else {
                for (Task task : tasksForDay) {
                    System.out.println("  - " + task); // Print each task assigned to the day
                }
            }
        }
    }
}
