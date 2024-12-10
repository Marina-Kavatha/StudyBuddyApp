package org.javawavers.studybuddy.courses;
import java.util.List;
// Καθε μέρα τι έχει ο χρήστης: αν έχει εξεταστική εκείνη την μέρα ή οχι και το σύνολο των μαθηματων εργασιών και των αντίστοιχων ωρών τους
public class Day {
    public enum DayStatus {
        EXAM,
        ASSIGNMENT_DEADLINE,
        FREE
    }

    List<String> subjectNames;
    List<Integer> subjectHours;
    List<String> assignmentsNames;
    List<Integer> assignmentsHours;
    DayStatus status = DayStatus.valueOf("FREE");
    boolean progress = false;
    int totalSlides;
    int slidesCompleted = 0;

 // αναλογα με τος πως λειτουργει ο αλγοριθμος αλλαζει και ο κατασκευαστης : η μερα αρχικοποιειται απο την αρχη οπου ο χρηστης βαζει τις ημερες που εχει προθεσμιες ή οχι ,
 //  ή αρχικοποιειται οταν ο αλγοριθμος βγαζει το συνολο των μαθηματων και των ωρων,...
    public Day (List<String> subjectNames, List<Integer> subjectHours, List<String> assignmentsNames, List<Integer> assignmentsHours, DayStatus status) {
        this.subjectNames = subjectNames;
        this.subjectHours = subjectHours;
        this.assignmentsNames = assignmentsNames;
        this.assignmentsHours = assignmentsHours;
    }

    List<String> getSubjectNames() {return  subjectNames;};

    void setSubjectNames(List<String> subjectNames) {this.subjectNames = subjectNames;};

    List<Integer> getSubjectHours() {return  subjectHours;};

    void setSubjectHours(List<Integer> subjectHours) {this.subjectHours = subjectHours;};

    List<String> getAssignmentsNames() {return  assignmentsNames;};

    void setAssignmentsNames(List<String> assignmentsNames) {this.assignmentsNames = assignmentsNames;};

    List<Integer> getAssignmentsHours() {return  assignmentsHours;};

    void setAssignmentsHours(List<Integer> assignmentsHours) {this.assignmentsHours = assignmentsHours;};

    int getTotalSlides() {return totalSlides;};

    void setTotalSlides(int totalSlides) {this.totalSlides = totalSlides;};

    int getSlidesCompleted() {return slidesCompleted;};

    void setSlidesCompleted(int slidesCompleted) {this.slidesCompleted = slidesCompleted;};

    //εμφανιζει τα ονοματα των μαθηματων, των εργασιων και των ωρών τους
    void printDay(){
        for (String i : subjectNames) {
            System.out.println(i);
            System.out.println(subjectHours.get(Integer.parseInt(i)));
        }
        for (String i : assignmentsNames) {
            System.out.println(i);
            System.out.println(assignmentsHours.get(Integer.parseInt(i)));
        }
    }
    // ενημερωνει ο αλγοριθμοσ ή ενημερωνεται στην αρχη αν εχει κατι εκείνη τη μέρα
    void updateStatus(DayStatus status ) {
        this.status = status;
    }

    void updateProgress (boolean progress) {
        this.progress = progress;
    }
    boolean isProgressUpdated() {
        return progress;
    }
    //calculateProductivity() για τον υπολογισμο της προοδου θα πρεπι να εχουμε δυο μεταβλητες για ωστε να εχουμε τα αποτελεσματα
    // που εχει η λυση αλλα και το τι πραγματικα έκανε ο χρηστης
    //calculateDailyEfficiency(): double
    //calculateSlideCompletionRate(): double
    //slidesCompleted θα το ανανεωνεται με βαση τι εκανε ο χρηστης
    //int totalSlides: int τι εχει υπολογισει το προγραμμα
}

