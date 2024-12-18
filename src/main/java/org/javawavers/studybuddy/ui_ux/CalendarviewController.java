package org.javawavers.studybuddy.ui_ux;

import java.io.IOException;

import org.javawavers.studybuddy.StudyBuddyApp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CalendarviewController {

    @FXML
    private Button myButton;


    @FXML
    private void onButtonClick() {
        openPopup();
    }

    // Μέθοδος για να ανοίξει το Popup
    private void openPopup() {
        try {
            // Χρησιμοποιήστε τη σωστή σχετική διαδρομή
            FXMLLoader loader = new FXMLLoader(StudyBuddyApp.class.getResource("popupdiathesimotita.fxml"));
            Scene scene = new Scene(loader.load());
    
            Stage stage = new Stage();
            stage.setTitle("Popup Window");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
