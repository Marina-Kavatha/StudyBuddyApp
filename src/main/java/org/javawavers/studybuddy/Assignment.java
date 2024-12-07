package org.javawavers.studybuddy;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;



    public class Assignment {

        //θεωρω πως εχουμε παρει απο την βαση δεδομενων ειτε απο την μνημη της εφαρμογης : μια λιστα με τις εργασιες που εχει ο χρηστης , μια λιστα με τα deadllines της καθε εργασιας και την εκφωνηση της ασκησης
        
            ListAssignment listassignment = new ListAssignment();
        //περνουμε απο την κλαση listAssignment τις λιστες για τις προθεσμιες και για τα μαθηατα και τις εργασιες . στην πραγματικοτητα αυτη η κλαση θα ειναι η σελιδα που θα εισαγει ο χρηστης τα μαθηματα
            ArrayList<ArrayList<String>> assigment = listassignment.getAssigments();
            ArrayList<ArrayList<LocalDate>> deadline = listassignment.getDeadline();
        //λιστα για της εκφωνησης 
            ArrayList<ArrayList<String>> description = listassignment.getDescription();
            ArrayList<ArrayList<Integer>> remaingdays = new ArrayList<>(); //δημιουργια νεας λιστας η οποια θα εχει τις μερες που απομενουν μεσα
        //παιρνουμε την σημερινη ημερα 
            LocalDate today = LocalDate.now();
                public void getRemainingHours(LocalDate today) { //μεθοδος υπολογισμου ποσες μερες μενουν ακομα για την ληξη της προθεσμιας
                    for (int i = 0; i < deadline.size(); i++) {
                        ArrayList<Integer> subjectremainingdays = new ArrayList<>();//δημιουργια λιστας για να περνουμε σε καθε γραμμη της προθεσμιες του συγκεκριμενου μαθηματος και να το προστεθουμε αργοτερα στην λιστα
                    
                        for (int j = 0; j < deadline.get(i).size(); j++) {
                            LocalDate duedate = deadline.get(i).get(j);//παιρνει την συδκεκριμενη ημερομηνια του deadline
                            long daysremaining = ChronoUnit.DAYS.between(today,duedate );//με αυτην την εντολη η βιβλιοθηκη chronounit επιστρεφει τις μερες που εχουν διαφορα δυο ημερομηνιες
                            subjectremainingdays.add((int) daysremaining);//το προσθετουμε στο μαθημα
                        }
                        remaingdays.add(subjectremainingdays);//προστεθουμε την γραμμη
                    }
        
        
        
                }
        //μεθοδος υπολογισμου αν για καποια εργασια σε συγκεκριμενο μαθημα ειναι κοντα στην προθεσμαι (δηλαδη λιγοτερο απο 10 μερες) 
                public boolean isDuesoon(int subjecttt, int Assignmenttt) {
                    int dueDate = remaingdays.get(subjecttt).get(Assignmenttt);
                    if (dueDate > 10) {
                        return false;
                    } else {
                        return true;
                    }
        
                }
        //δημιουργια λιστων με λεξεις κλειδια για τον υπολογισμο της δυσκολιας της καθε εργασιας αναλογα με την εκφωνηση και το επιπεδο δυσκολιας
                public static final ArrayList<String> keywords1 = new ArrayList<>() {{
                    add("x");
                }};
        
                public static final ArrayList<String> keywords2 = new ArrayList<>() {{
                    add("x");
                }};
        
                public static final ArrayList<String> keywords3 = new ArrayList<>() {{
                    add("x");
                }};
        
        
        
        
        //μετραει ποσες λεξεις κλειδια εχει η εκφωνηση και με ποια δυσκολια επιστρεφει 
                public double difficultyestmator(String description) {
        //μετρητες για τις λεξεις κλειδια ανα δυσκολια (ευκολο,μετριο,δυσκολο)
                    int count1 = 0;
                    int count2 = 0;
                    int count3 = 0;
        //βαζουμε ολες τις λεξεις της εκφωμησης σε πινακα μεμονομενες ωστε να μπορουμε να τις ελενξουμε
                    String[] words = description.toLowerCase().split("\\s+");
        //μετραμε για καθε λιστα ποσες λεξεις περιεχει ανα κατηγορια
                    for (String word : words) {
                        if ( keywords1.contains(word)) {
                            count1++;
                        }
                    }
                    for (String word : words) {
                        if ( keywords2.contains(word)) {
                            count2++;
                        }
                    }
                    for (String word : words) {
                        if ( keywords3.contains(word)) {
                            count3++;
                        }
                    }
        //μετραμε το score της συγκεκριμενης εκφωνησης
                    double difficulty = count1 * 0.2 + count2 * 0.3 * count3 * 0.5;
        //μετραμε την συνολικη μεγιστη βαθμολογια δυσκολιας που μπορει να παρει καποιος 
                    final double maxdiff = (keywords1.size() * 0.2) + (keywords2.size() * 0.3) + (keywords3.size() * 0.5);
        //βγαζουμε το score για κλιμακα απο 1 - 10 
                    double score = 1 + (difficulty / maxdiff) * 9;
        //μηχανισμος ασσφαλειας σε λαθος εισαγωγη δεδομενων να μην μπορει το αποτελεσμα να ειναι πανω απο 10. η κατω απο 1 , 0.
                    double finascore = Math.min(10, Math.max(1, score));
        //επισστρεφουμε την συνολικη βαθμολογια
                    return finascore;
                }
        
            
                
                
        
    }  
