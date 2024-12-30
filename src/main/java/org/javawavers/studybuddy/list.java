package org.javawavers.studybuddy;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
public class list extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Δημιουργία της ListView
        ListView<String> listView = new ListView<>();

        // Προσθήκη των εικόνων
        listView.getItems().addAll("Εικονίδιο 1", "Εικονίδιο 2", "Εικονίδιο 3", "Εικονίδιο 4");

        // Προσθήκη εικόνας σε κάθε στοιχείο της λίστας
        listView.setCellFactory(new Callback<ListView<String>, javafx.scene.control.ListCell<String>>() {
            @Override
            public javafx.scene.control.ListCell<String> call(ListView<String> param) {
                return new javafx.scene.control.ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null && !empty) {
                            // Δημιουργία ενός ImageView με την αντίστοιχη εικόνα
                            ImageView imageView = new ImageView();
                            Image image = null;
                            
                            // Αλλαγή εικόνας ανάλογα με το στοιχείο
                            switch (item) {
                                case "Εικονίδιο 1":
                                    image = new Image(getClass().getResource("/org/javawavers/studybuddy/eikona.png").toExternalForm()); // Διαδρομή εικόνας
                                    break;
                                case "Εικονίδιο 2":
                                    image = new Image(getClass().getResource("/org/javawavers/studybuddy/eikona3.png").toExternalForm());
                                    break;
                                case "Εικονίδιο 3":
                                    image = new Image(getClass().getResource("/org/javawavers/studybuddy/eikona2.png").toExternalForm());
                                    break;
                                case "Εικονίδιο 4":
                                    image = new Image(getClass().getResource("/org/javawavers/studybuddy/eikona1.png").toExternalForm());
                                    break;
                                default:
                                    break;
                            }

                            if (image != null) {
                                imageView.setImage(image);
                                imageView.setFitWidth(30); // Μπορείς να ρυθμίσεις το μέγεθος
                                imageView.setFitHeight(30); // Μπορείς να ρυθμίσεις το μέγεθος
                                setGraphic(imageView); // Θέτουμε την εικόνα στο κελί
                            }
                        } else {
                            setGraphic(null);
                        }
                    }
                };
            }
        });

        // Δημιουργία VBox για να τοποθετήσουμε τη ListView
        VBox vbox = new VBox(listView);

        // Σκηνή και Στάδιο
        Scene scene = new Scene(vbox, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ListView with Images");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
