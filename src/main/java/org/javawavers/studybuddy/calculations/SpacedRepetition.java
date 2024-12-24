package org.javawavers.studybuddy.calculations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SpacedRepetition {

    public class Lesson {
        private String title;
        private int step; //σε ποιο στάδιο βρίσκεται η επανάληψη
        private LocalDate nextReviewDate; //την ημερομηνία της επόμενης επανάληψης

        public Lesson(String title) { //κατασκευαστης
            this.title = title;
            this.step = 1; //η επαναληψη ξεκινά με στάδιο 1
            this.nextReviewDate = this.getNextReviewDate();
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public LocalDate getNextReviewDate() {
            nextReviewDate = LocalDate.now().plusDays(getInterval(step));
            return nextReviewDate;
        }

        public int getStep() {
            return step;
        }

        private int getInterval(int step) {   // επιστρέφει το διάστημα για την επόμενη επανάληψη με βάση πόσες επαναλήψεις έχει ήδη κάνει
            if (step == 1)
                return 1;
            if (step == 2)
                return 7;
            if (step == 3)
                return 16;
            if (step == 4)
                return 35;
            else
                return getInterval(step - 1) * 2;
        }

        public void setStep(boolean remember) { //remember-αν θυμάται μια πληροφορία
            if (remember == false) {
                step = 1; //αν ξεχάσει τελείως μία πληροφορία τότε η επανάληψη ξαναρχίζει από την αρχή
            } else {
                step++; //αν θυμάται την πληροφορία τότε πάει στο επόμενο βήμα της επανάληψης
            }
        }

        @Override
        public String toString() {
            return "για το μάθημα=" + title + " που βρίσκεται στο στάδιο επανάληψης=" + step
                    + " η επόμενη ημερομηνία για επανάληψη είναι=" + nextReviewDate;
        }
    } //τέλος εσωτερικής κλάσης Lesson

    private List<Lesson> lessons; //λίστα με τα μαθηματα

    public SpacedRepetition() { // ο κατασκευαστης αρχικοποεί μια κενή λίστα για την αποθήκευση των μαθημάτων
        this.lessons = new ArrayList<>();
    }

    public void addLesson(String title) { //προσθέτει ενα μάθημα στην λίστα
        lessons.add(new Lesson(title));
    }

    public List<Lesson> getDueLessons(LocalDate date) {    //επιστρέφει όλα μαθήματα που πρέπει να διαβάσει μια μέρα
        List<Lesson> dueLessons = new ArrayList<>();  //δημιουργια πινακα για μαθήματα
        for (Lesson lesson : lessons) {
            if (lesson.getNextReviewDate() == date) {  // αν η ημερομηνια επόμενης επανάληψης ειναι η ημερομηνία στο όρισμα τοτε το προσθέτει στην λίστα
                dueLessons.add(lesson);
            }
        }
        return dueLessons;
    }
}