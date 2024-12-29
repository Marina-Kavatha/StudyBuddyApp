import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class MainTest {
    public static void main(String[] args) {
        // Create subjects
        Subject Maths = new Subject("Maths", 5, null, null);
        Exam e1 = new Exam(LocalDate.of(2025, 01, 04), 300);
        Maths.addExam(e1);
        Subject History = new Subject("History", 4, null, null);
        Exam e2 = new Exam(LocalDate.of(2025, 01, 06), 100);
        History.addExam(e2);
        ArrayList<Subject> subs = new ArrayList<>();
        subs.add(Maths);
        subs.add(History);
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

        Availability.setNonAvailability(LocalDate.of(2025, 01, 02));

        SimulateAnnealing sAnnealing = new SimulateAnnealing();

        for (Subject s : subs) {
            sAnnealing.addSubject(s);

        }

        System.out.println(e1.getExamDate());
        System.out.println(e2.getExamDate());
        LocalDate today = LocalDate.now();

        long daysBetween1 = ChronoUnit.DAYS.between(today, e1.getExamDate());
        System.out.println(" Days up to Maths exam" + daysBetween1);
        long daysBetween2 = ChronoUnit.DAYS.between(today, e2.getExamDate());
        System.out.println(" Days up to History exam" + daysBetween2);

        SimulateAnnealing.SchedulResult();
    }
}
