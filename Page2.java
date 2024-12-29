package main.java;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Page2 extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Root container
        VBox root = new VBox(20);
        root.setAlignment(javafx.geometry.Pos.CENTER);
        root.setPrefSize(994, 562);

        // Navigation Bar
        HBox navBar = new HBox(10);
        navBar.setPrefSize(901, 86);
        navBar.setStyle("-fx-background-color: #40E0D0;");
        navBar.setPadding(new Insets(10, 0, 0, 30));

        // Navigation items
        Label logo = new Label("StudyBuddy");
        logo.setFont(new Font("Agency FB Bold", 26));
        logo.setTextFill(javafx.scene.paint.Color.web("#f2eded"));
        logo.setPadding(new Insets(20, 0, 0, 20));

        Button btnSeeHow = new Button("Δες Πως");
        btnSeeHow.setFont(new Font(11));
        btnSeeHow.setStyle("-fx-font-weight: bold;");
        btnSeeHow.setPrefSize(167, 42);

        Button btnNewsTips = new Button("Νέα και Συμβουλές");
        btnNewsTips.setStyle("-fx-font-weight: bold;");
        btnNewsTips.setPrefSize(218, 41);

        Button btnAboutUs = new Button("Ποιοι είμαστε");
        btnAboutUs.setStyle("-fx-font-weight: bold;");
        btnAboutUs.setPrefSize(177, 41);

        Button btnLogin = new Button("Συνδέσου εδώ");
        btnLogin.setStyle("-fx-font-weight: bold; -fx-background-color: #d7ad6e;");
        btnLogin.setTextFill(javafx.scene.paint.Color.web("#fcfaf8"));
        btnLogin.setPrefSize(186, 41);

        navBar.getChildren().addAll(logo, btnSeeHow, btnNewsTips, btnAboutUs, btnLogin);

        // Main content pane
        Pane mainPane = new Pane();
        mainPane.setPrefSize(994, 474);

        Button btnRight = new Button("→");
        btnRight.setLayoutX(621);
        btnRight.setLayoutY(203);
        btnRight.setStyle("-fx-font-size: 18px;");
        btnRight.setFont(new Font("Arial Bold", 9));

        Button btnLeft = new Button("←");
        btnLeft.setLayoutX(300);
        btnLeft.setLayoutY(203);
        btnLeft.setStyle("-fx-background-color: pink; -fx-background-radius: 50%; -fx-min-width: 30px; -fx-min-height: 30px; -fx-max-height: 30px; -fx-max-width: 30px; -fx-text-fill: white; -fx-font-size: 18px; -fx-font-weight: bold;");
        btnLeft.setFont(new Font("Agency FB Bold", 14));

        Button backButton = new Button("Back to Page 1");
        backButton.setLayoutX(7);
        backButton.setLayoutY(427);

        VBox box1 = createVBox(14, 98, 284, 251, "Label");
        VBox box2 = createVBox(315, 98, 321, 251, "Create Your Study Plan in Minutes!");
        VBox box3 = createVBox(654, 95, 314, 251, "Label");

        Label headerLabel = new Label("Δες Πως ");
        headerLabel.setFont(new Font("Arial", 22));
        headerLabel.setLayoutX(443);
        headerLabel.setLayoutY(8);

        mainPane.getChildren().addAll(btnRight, btnLeft, backButton, box1, box2, box3, headerLabel);

        // Add components to root
        root.getChildren().addAll(navBar, mainPane);

        // Create scene
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Page 2");
        primaryStage.show();
    }

    private VBox createVBox(double x, double y, double width, double height, String text) {
        VBox vbox = new VBox();
        vbox.setLayoutX(x);
        vbox.setLayoutY(y);
        vbox.setPrefSize(width, height);
        vbox.setStyle("-fx-border-color: pink; -fx-border-width: 2px; -fx-border-radius: 5px; -fx-padding: 10px;");

        Label label = new Label(text);
        label.setFont(new Font("Arial Narrow Bold Italic", 14));
        vbox.getChildren().add(label);

        return vbox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
