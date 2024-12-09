import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class calendarController {

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            // Φόρτωση του FXML της νέας σελίδας
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SecondPage.fxml"));
            Parent root = loader.load();

            // Δημιουργία της σκηνής
            Scene scene = new Scene(root);

            // Απόκτηση του Stage από το event
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Εναλλαγή στη νέα σκηνή
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
