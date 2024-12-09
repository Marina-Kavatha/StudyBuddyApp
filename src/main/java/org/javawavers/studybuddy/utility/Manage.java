package org.javawavers.studybuddy.utility;

public class Manage {
     // Πεδίο τύπου που υποδεικνύει τον τύπο διαχείρισης (π.χ., Exam, User, Subject κ.α)
     protected String type;

     public Manage(String type) {
         this.type = type;
     }
 
     // Μέθοδος προσθήκης ενός αντικειμένου στη διαχείριση
     // Παράμετρος: αντικείμενο τύπου Object για γενική χρήση
     public void add(Object obj) {
         // Εδώ θα εισαχθεί ο κώδικας για την προσθήκη του αντικειμένου
         System.out.println("Προστέθηκε αντικείμενο: " + obj.toString());
     }
 
     // Μέθοδος αφαίρεσης ενός αντικειμένου από τη διαχείριση
     public void remove(Object obj) {
         System.out.println("Αφαιρέθηκε αντικείμενο: " + obj.toString());
     }
 
     // Μέθοδος επεξεργασίας ενός αντικειμένου
     public void edit(Object oldObj, Object newObj) {
         System.out.println("Επεξεργασία αντικειμένου από: " + oldObj.toString() + " σε: " + newObj.toString());
     }
  
}

