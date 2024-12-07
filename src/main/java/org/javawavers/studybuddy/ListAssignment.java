package org.javawavers.studybuddy;

//εφτιαξα δυο δισδιαστατες λιστες στις οποιες εχω εισαγει εγω τα δεδομενα αλλα θεωρητικα θα ειναι του χρηστη με τις εργασιες που εχει ανα μαθημα και με τις προθεσμιες που εχει η καθε εργασια 
//για τα deadlines υποθετω οτι τα εχουμες μετατρεψει σε ημερες που μενουν ακομα 


import java.time.LocalDate;
import java.util.ArrayList;

public class ListAssignment {
    private ArrayList<ArrayList<String>> assigments = new ArrayList<>();
    private ArrayList<ArrayList<LocalDate>> deadline = new ArrayList<>();
//θελουμε και μια λιστα για την εκφωνηση της καθε ασκησης
private ArrayList<ArrayList<String>> description = new ArrayList<>();

//κατασκευαστης για αρχικοποιηση των λιστων
    public ListAssignment() {
        ArrayList<String> mathAssignment = new ArrayList<>();
        mathAssignment.add("homework 1");
        mathAssignment.add("homework 2");
        mathAssignment.add("homework 3");

        ArrayList<LocalDate> mathdeadline = new ArrayList<>();
        mathdeadline.add(LocalDate.of(2024, 12, 30));
        mathdeadline.add(LocalDate.of(2024, 12, 10));
        mathdeadline.add(LocalDate.of(2024, 12, 25));

        ArrayList<String> oikonomiksAssignment = new ArrayList<>();
        oikonomiksAssignment.add("homework 4");
        oikonomiksAssignment.add("homework 5");
        oikonomiksAssignment.add("homwork 6");

        ArrayList<String> programmAssignment = new ArrayList<>();
        programmAssignment.add("homework 7");
        programmAssignment.add("homework 8");

        assigments.add(mathAssignment);
        assigments.add(oikonomiksAssignment);
        assigments.add(programmAssignment);



        ArrayList<LocalDate> oikonomiksdeadline = new ArrayList<>();
        oikonomiksdeadline.add(LocalDate.of(2025, 3, 5));
        oikonomiksdeadline.add(LocalDate.of(2025, 4, 15));
        oikonomiksdeadline.add(LocalDate.of(2025, 1, 18));

        ArrayList<LocalDate> programmdeadline = new ArrayList<>();
        programmdeadline.add(LocalDate.of(2025, 1, 15));
        programmdeadline.add(LocalDate.of(2024, 12, 31));

        deadline.add(mathdeadline);
        deadline.add(oikonomiksdeadline);
        deadline.add(programmdeadline);

        ArrayList<String> mathdescription = new ArrayList<>();
        mathdescription.add("");
        mathdescription.add("");
        mathdescription.add("");

        ArrayList<String> oikonomiksdescription = new ArrayList<>();
        oikonomiksdescription.add("");
        oikonomiksdescription.add("");
        oikonomiksdescription.add("");

        ArrayList<String> programmdescription = new ArrayList<>();
        programmdescription.add("");
        programmdescription.add("");

        description.add(oikonomiksdescription);
        description.add(mathdescription);
        description.add(programmdescription);






    }


    public ArrayList<ArrayList<String>> getAssigments() {
        return new ArrayList<>(assigments);
    }

    public ArrayList<ArrayList<String>> getDescription() {
        return new ArrayList<>(description);
    }

    public ArrayList<ArrayList<LocalDate>> getDeadline() {
        return new ArrayList<>(deadline);
    }

}
