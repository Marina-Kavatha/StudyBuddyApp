package org.javawavers.studybuddy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Popupdiathesimotita extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        root.setStyle("-fx-background-radius: 20px; -fx-background-color: white;");
        root.setPrefSize(241, 280);

        Label lessonLabel = new Label("ΜΑΘΗΜΑ");
        lessonLabel.setFont(Font.font("System Bold", 18));
        lessonLabel.setLayoutX(14);
        lessonLabel.setLayoutY(14);
        root.getChildren().add(lessonLabel);

        Pane duePane = new Pane();
        duePane.setStyle("-fx-background-color: #D3D3D3;");
        duePane.setLayoutX(14);
        duePane.setLayoutY(52);
        duePane.setPrefSize(80, 23);

        Label dueLabel = new Label("Due:");
        dueLabel.setFont(Font.font(14));
        dueLabel.setLayoutX(2);
        dueLabel.setLayoutY(2);

        Label dateLabel = new Label("15/10");
        dateLabel.setFont(Font.font(14));
        dateLabel.setLayoutX(34);
        dateLabel.setLayoutY(2);

        duePane.getChildren().addAll(dueLabel, dateLabel);
        root.getChildren().add(duePane);

        Pane remainingPane = new Pane();
        remainingPane.setStyle("-fx-background-color: #D3D3D3;");
        remainingPane.setLayoutX(105);
        remainingPane.setLayoutY(52);
        remainingPane.setPrefSize(98, 23);

        Label remainingLabel = new Label("15 days left");
        remainingLabel.setFont(Font.font(14));
        remainingLabel.setLayoutX(10);
        remainingLabel.setLayoutY(1);

        remainingPane.getChildren().add(remainingLabel);
        root.getChildren().add(remainingPane);

        TextArea descriptionTextArea = new TextArea();
        descriptionTextArea.setText("Ολοκλήρωση των πρώτων 15 \nδιαφανείων.");
        descriptionTextArea.setStyle("-fx-border-color: black;");
        descriptionTextArea.setLayoutX(26);
        descriptionTextArea.setLayoutY(91);
        descriptionTextArea.setPrefSize(189, 124);
        root.getChildren().add(descriptionTextArea);

        CheckBox finishedCheckBox = new CheckBox("Finished");
        finishedCheckBox.setFont(Font.font("System Bold", 14));
        finishedCheckBox.setLayoutX(26);
        finishedCheckBox.setLayoutY(227);
        finishedCheckBox.setStyle("-fx-background-color: #15B569; -fx-background-radius: 20px;");
        root.getChildren().add(finishedCheckBox);

        Pane inPane = new Pane();
        inPane.setStyle("-fx-background-radius: 30px; -fx-background-color: #FFC23D;");
        inPane.setLayoutX(129);
        inPane.setLayoutY(227);
        inPane.setPrefSize(98, 30);

        Label inLabel = new Label("In : (minutes)");
        inLabel.setFont(Font.font("System Bold", 14));
        inLabel.setLayoutX(8);
        inLabel.setLayoutY(5);

        inPane.getChildren().add(inLabel);
        root.getChildren().add(inPane);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Task Layout");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
