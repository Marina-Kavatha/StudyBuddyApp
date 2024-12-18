package org.javawavers.studybuddy;



import javafx.application.Application;
import javafx.stage.Stage;

public class StudyBuddyApp extends Application {


    @Override
    public void start(Stage primaryStage) {
//ανοιγουμε αρχικα την σελιδα εγγραφης      
        Signup signup = new Signup();
        Stage signupStage = new Stage();
        signup.start(signupStage);
            
//αν ο χρηστης εχει maximize την οθονη τοτε του εμφανιζεται maximize και η νεα οθονη
        if (primaryStage.isMaximized()) {
            signupStage.setMaximized(true);
        }
        
        signupStage.show();
        
        
        
        
    }


    public static void main(String[] args) {
        launch(args);
    }
}
