package org.javawavers.studybuddy;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/*
TODO :
 * same as ExamPage
 */
public class AssignmentPage {
    // Assignment Page as Node
    public Node AssignmentPanel() {
        VBox assignmentPanel = new VBox(20);
        assignmentPanel.setPadding(new Insets(20));

        // Create sections as titledPanes in order to be foldable
        TitledPane coursePane = new TitledPane("Μάθημα", createCourseSection());
        TitledPane infoPane = new TitledPane("Πληροφορίες", createInfoSection());
        TitledPane evalPane = new TitledPane("Αξιολόγηση", createEvalSection());

        titlePaneStyle(coursePane,200, 400, 0, 300);
        titlePaneStyle(infoPane,200, 400, 0, 300);
        titlePaneStyle(evalPane,200, 400, 0, 300);

        //"ok" Button
        Button okBtn = new Button("OK");
        okBtn.setStyle(btnStyle());
        okBtn.setOnMouseEntered(e -> okBtn.setStyle(btnMouseEntered()));
        okBtn.setOnMouseClicked(e -> okBtn.setStyle(btnMousePressed()));
        okBtn.setAlignment(Pos.CENTER_LEFT);

        HBox okBtnHBox = new HBox(10);
        okBtnHBox.setAlignment(Pos.CENTER_LEFT);
        okBtnHBox.getChildren().add(okBtn);

        //adds all the exam page parts to the panel
        assignmentPanel.getChildren().addAll(coursePane, infoPane, evalPane, okBtnHBox);

        return assignmentPanel;  //returns the page
    }

    // Section for Course name
    private VBox createCourseSection() {
        VBox box = new VBox(10);
        Label nameLabel = new Label("Μάθημα Εργασίας:");
        nameLabel.setStyle(labelStyle());

        ComboBox<String> coursesList = new ComboBox<>();
        //coursesList.setPromptText(" ");
        coursesList.getItems().addAll("","Μαθηματικά", "Ιστορία", "Φυσική");
        coursesList.setValue("");


        box.getChildren().addAll(nameLabel, coursesList);
        return box;
    }

    // Section for course information
    private VBox createInfoSection() {
        VBox box = new VBox(10);
        box.getChildren().addAll(
                createLabeledField("Tίτλος Εργασίας:"),
                createLabeledField("Ημερομηνία Παράδοσης:"),
                createLabeledField("Εκτιμώμενες Απαιτούμενες Ώρες:")
        );
        return box;
    }

    // Section for course evaluation
    private VBox createEvalSection() {
        VBox box = new VBox(10);
        box.getChildren().addAll(
                createLabeledField("Δυσκολία:")
        );
        return box;
    }

    // Label field
    private HBox createLabeledField(String labelText) {
        Label label = new Label(labelText);
        label.setStyle(labelStyle());
        TextField textField = new TextField();
        return new HBox(10, label, textField);
    }

    //label style
    private String labelStyle() {
        return "-fx-background-color: rgba(181, 99, 241, 0.81);"
                + " -fx-padding: 5;"
                + " -fx-border-width: 1px;"
                + " -fx-border-radius: 4px;"
                + " -fx-background-radius: 4px;";
    }

    //titlePane style
    private void titlePaneStyle(TitledPane titledPane,
                                double minWidth, double maxWidth,
                                double minHeight, double maxHeight) {

        titledPane.setMinWidth(minWidth);
        titledPane.setMaxWidth(maxWidth);
        titledPane.setMinHeight(minHeight);
        titledPane.setMaxHeight(maxHeight);


        titledPane.setStyle("-fx-background-color: rgba(101, 225, 101, 0.81);"
                +   " -fx-border-color: #000000;"
                +   " -fx-border-width: 1px;"
                +   " -fx-border-radius: 4px;"
                +   " -fx-background-radius: 4px;");

    }

    //Button Styles
    private String btnStyle() {
        return "-fx-background-color: linear-gradient(#FAD7A0, #F7B267);"
                + "-fx-background-radius: 8,7,6;"
                + "-fx-background-insets: 0,1,2;"
                + "-fx-text-fill: #5A3D2B;"
                + "-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.3), 5, 0, 2, 2);"
                + "-fx-font-weight: bold;"
                + "-fx-padding: 10 20;"
                + "-fx-border-color: #D98A4B;"
                + "-fx-border-radius: 6;";
    }


    private String btnMouseEntered() {
        return "-fx-background-color: linear-gradient(#FFE0B2, #F7B267);"
                + "-fx-background-radius: 8,7,6;"
                + "-fx-background-insets: 0,1,2;"
                + "-fx-text-fill: #5A3D2B;"
                + "-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.3), 5, 0, 2, 2);"
                + "-fx-font-weight: bold;"
                + "-fx-padding: 10 20;"
                + "-fx-border-color: #D98A4B;"
                + "-fx-border-radius: 6;";
    }

    private String btnMousePressed() {
        return "-fx-background-color: linear-gradient(#F7B267, #D98A4B);"
                + "-fx-background-radius: 8,7,6;"
                + "-fx-background-insets: 0,1,2;"
                + "-fx-text-fill: #5A3D2B;"
                + "-fx-font-weight: bold;"
                + "-fx-padding: 10 20;"
                + "-fx-border-color: #D98A4B;"
                + "-fx-border-radius: 6;"
                + "-fx-effect: none;";
    }
}
