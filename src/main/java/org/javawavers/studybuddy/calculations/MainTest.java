import java.time.LocalDate;

public class MainTest {
    public static void main(String[] args) {
        // Create subjects
        Subject Maths = new Subject("Maths", 5, null, null);
        Exam e1 = new Exam(LocalDate.of(2025, 02, 28), 400);
        Maths.addExam(e1);
        Subject History = new Subject("History", 4, null, null);
        Exam e2 = new Exam(LocalDate.of(2025, 02, 28), 300);
        Maths.addExam(e2);
        // create Availability
        Availability.setAvailability(1, 6); // Monday: 6 available hours
        Availability.setAvailability(2, 4); // Tuesday: 4 available hours
        Availability.setAvailability(3, 7); // Wednesday: 7 available hours
        Availability.setAvailability(4, 4); // Thursday: 4 available hours
        Availability.setAvailability(5, 6); // Friday: 6 available hours
        Availability.setAvailability(6, 6); // Saturday: 6 available hours
        Availability.setAvailability(7, 6); // Sunday: 6 available hour
        // create non Availability
        Availability.setNonAvailability(LocalDate.of(2024, 12, 31));
        Availability.setNonAvailability(LocalDate.of(2024, 12, 30));
        Availability.setNonAvailability(LocalDate.of(2025, 01, 01));

        SimulateAnnealing sAnnealing = new SimulateAnnealing();
        sAnnealing.addSubject(History);
        sAnnealing.addSubject(Maths);
        SimulateAnnealing.SchedulResult();
    }
}
