package org.javawavers.studybuddy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Popupdia extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        root.setPrefSize(428, 444);
        root.setStyle("-fx-border-color: black;");

        Label label1 = new Label("       Διαθεσημότητα");
        label1.setLayoutX(27);
        label1.setLayoutY(49);
        label1.setPrefSize(169, 30);
        label1.setStyle("-fx-background-color: #50D1C6;");
        label1.setFont(new Font("System Bold", 14));

        Label label2 = new Label("    Συγκεκριμένη Ημέρα");
        label2.setLayoutX(232);
        label2.setLayoutY(49);
        label2.setPrefSize(169, 30);
        label2.setStyle("-fx-background-color: #50D1C6;");
        label2.setFont(new Font("System Bold", 14));

        Label monday = createDayLabel("Δευτέρα", 92);
        Label tuesday = createDayLabel("Τρίτη", 134);
        Label wednesday = createDayLabel("Τετάρτη", 176);
        Label thursday = createDayLabel("Πέπμτη", 221);
        Label friday = createDayLabel("Παρασκευή", 263);
        Label saturday = createDayLabel("Σάββατο", 305);
        Label sunday = createDayLabel("Κυριακή", 352);

        TextField mondayField = createTextField(92);
        TextField tuesdayField = createTextField(134);
        TextField wednesdayField = createTextField(176);
        TextField thursdayField = createTextField(221);
        TextField fridayField = createTextField(263);
        TextField saturdayField = createTextField(305);
        TextField sundayField = createTextField(352);

        TextField specificDayField = new TextField();
        specificDayField.setLayoutX(242);
        specificDayField.setLayoutY(98);

        root.getChildren().addAll(label1, label2, monday, tuesday, wednesday, thursday, friday, saturday, sunday,
                mondayField, tuesdayField, wednesdayField, thursdayField, fridayField, saturdayField, sundayField,
                specificDayField);

        Scene scene = new Scene(root, 428, 444);
        primaryStage.setTitle("Calendar View");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Label createDayLabel(String day, double layoutY) {
        Label label = new Label(day);
        label.setLayoutX(27);
        label.setLayoutY(layoutY);
        label.setPrefSize(94, 36);
        label.setStyle("-fx-background-color: #CF308C; -fx-background-radius: 20px;");
        label.setTextFill(javafx.scene.paint.Color.web("#f8f4f4"));
        label.setFont(new Font("System Bold", 14));
        return label;
    }

    private TextField createTextField(double layoutY) {
        TextField textField = new TextField();
        textField.setLayoutX(126);
        textField.setLayoutY(layoutY);
        textField.setPrefSize(94, 36);
        textField.setStyle("-fx-background-radius: 20px;");
        return textField;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
