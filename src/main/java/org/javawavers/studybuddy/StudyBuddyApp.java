package org.javawavers.studybuddy;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;

public class StudyBuddyApp extends Application {


    @Override
    public void start(Stage primaryStage) {
        
/*
//ΤO DO: οταν ανοιγει μια σελιδα θελουμε η αλλη να κλεινει αυτο για ολες τις σελιδες εκτος απο τα popups 
//ανοιγουμε αρχικα την σελιδα εγγραφης
        Signup signup = new Signup();
        Stage signupStage = new Stage();
        signup.start(signupStage);
            
//αν ο χρηστης εχει maximize την οθονη τοτε του εμφανιζεται maximize και η νεα οθονη
        if (primaryStage.isMaximized()) {
            signupStage.setMaximized(true);
        }
        
        signupStage.show();
        
 */
        ArrayList<SubjectTest> subject = new ArrayList<>();
        // Initialize Availability (example)
        Availability.setAvailability(1, 6); // Monday: 6 available hours
        Availability.setAvailability(2, 4); // Tuesday: 4 available hours
        Availability.setAvailability(3, 7); // Wednesday: 5 available hours
        Availability.setAvailability(4, 4); // Thursday: 3 available hours
        Availability.setAvailability(5, 6); // Friday: 6 available hours
        Availability.setAvailability(6, 6); // Saturday: 2 available hours
        Availability.setAvailability(7, 6); // Sunday: 1 available hour


        String color = "red";
        // Create subjects (example)
        SubjectTest math = new SubjectTest("Maths", 2.5, 600, LocalDate.now().plusDays(65),color);
        String color1 = "blue";
        SubjectTest history = new SubjectTest("History", 1.8, 680, LocalDate.now().plusDays(65), color1);

        // Add subjects to SimulateAnnealing
        SimulateAnnealing simulateAnnealing = new SimulateAnnealing();
        simulateAnnealing.addSubject(math);
        simulateAnnealing.addSubject(history);
        subject.add(math);
        subject.add(history);
        
        int[][] schedule = SimulateAnnealing.SchedulResult();
        List<Task> besttask = SimulateAnnealing.getBestTask();
        
        Calendar  calendar = new Calendar();
        calendar.besttask = besttask;
        calendar.schedule = schedule;
        Stage calendarStage = new Stage();
        calendar.start(calendarStage);
        

    }

    
    


    public static void main(String[] args) {
        launch(args);
    }
    
}
