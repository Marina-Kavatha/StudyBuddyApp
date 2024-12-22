package org.javawavers.studybuddy;



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
        
        Calendar  calendar = new Calendar();
        Stage calendarStage = new Stage();
        calendar.start(calendarStage);


    }


    public static void main(String[] args) {
        launch(args);
    }
}
