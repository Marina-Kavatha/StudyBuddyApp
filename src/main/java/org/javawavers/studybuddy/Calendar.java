package org.javawavers.studybuddy;


import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;



public class Calendar extends Application {
    //MainTestAlgorithm mt = new MainTestAlgorithm();
    StudyBuddyApp st = new StudyBuddyApp();
   
   //SimulateAnnealing simulateAnnealing = new SimulateAnnealing();
   // = simulateAnnealing.besttask;
   //List<Task> besttask = st.besttask;
        

        
   public static List<Task> besttask;
   public static int[][] schedule;
   List<Subject> subjects;


    @Override
    public void start(Stage primaryStage) {
        // Αρχικοποιουμε ολα τα panel
        VBox leftPanel = createLeftPanel();
        VBox centerPanel = createCenterPanel();
        VBox rightPanel = createRightPanel();

        //  κυριο layout
        BorderPane root = new BorderPane();
        root.setLeft(leftPanel);
        root.setCenter(centerPanel);
        root.setRight(rightPanel);

        // Δημιουργια σκηνης
        Scene scene = new Scene(root, 1115, 747);

        // εμφανιζουμε την σκηνη και ρυθμιζουμε το ονομα της σελιδας
        primaryStage.setScene(scene);
        primaryStage.setTitle("Study Buddy - Calendar");
        primaryStage.setResizable(true);
        primaryStage.show();

        // Προσαρμοζομαι το παραθυρο αναλογα οταν ειναι maximize και minimize
        scene.widthProperty().addListener((obs, oldWidth, newWidth) -> adjustLayout(root, scene));
        scene.heightProperty().addListener((obs, oldHeight, newHeight) -> adjustLayout(root, scene));
    }

    // μεθοδος για την προσαρμογη του παραθυρου
    private void adjustLayout(BorderPane root, Scene scene) {
        double widthFactor = scene.getWidth() / 1115;  // πλατος
        double heightFactor = scene.getHeight() / 747;  // υψος
    

        VBox leftPanel = (VBox) root.getLeft();
        VBox centerPanel = (VBox) root.getCenter();
        VBox rightPanel = (VBox) root.getRight();
    
        double sidePanelWidth = scene.getWidth() * 0.15;
        leftPanel.setPrefWidth(sidePanelWidth);
        rightPanel.setPrefWidth(sidePanelWidth);
    

        centerPanel.setPrefWidth(scene.getWidth() - 2 * sidePanelWidth);
    

        leftPanel.setPrefHeight(scene.getHeight());
        centerPanel.setPrefHeight(scene.getHeight());
        rightPanel.setPrefHeight(scene.getHeight());
    

        GridPane calendarGrid = (GridPane) centerPanel.getChildren().get(2);
        adjustCalendarGrid(calendarGrid, widthFactor, heightFactor);
    }
    
    // Προσαρμογη του πινακα οταν αλλαζει το μεγεθος και αντοιστοιχοι προσαρμογη των κελιων 
    private void adjustCalendarGrid(GridPane grid, double widthFactor, double heightFactor) {
        int numberOfCells = grid.getChildren().size();  // περνουμε τους αριθμους για τον πινακα

    
        for (int row = 1; row <= 5; row++) {
            for (int col = 0; col < 7; col++) {
                int index = row * 7 + col;
                if (index < numberOfCells) {
                    Label cell = (Label) grid.getChildren().get(index);
                    cell.setPrefWidth(124 * widthFactor);
                    cell.setPrefHeight(100 * heightFactor);
                } 
            }
        }
    }
    


//δημιουργουμε το αριστερο panel
    private VBox createLeftPanel() {
        VBox leftPanel = new VBox(10);
        leftPanel.setPadding(new Insets(10));
//οριζουμε το χρωμα
        leftPanel.setStyle("-fx-background-color: #CF7330;");

//οριζουμε το ονομα και το μεγεθος του label : user
        Label userNameLabel = new Label("UserName");
        userNameLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white;");

//δημιουργουμε τα κουμπια για το αριστερο μερος
        Button dashboardButton = createSideButton1("Dashboard");
        Button calendarButton = createSideButton1("Calendar");

//φτιαχνουμε το vbox για το study και το assignments και προσθετουμε τα κουμπια
        VBox coursesSection = new VBox(5);
        coursesSection.setPadding(new Insets(10, 0, 0, 0));
        Label coursesLabel = new Label("Courses");
        coursesLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white;");


        Button studyButton = createSideButton1("Study");
        Button assignmentsButton = createSideButton1("Assignments");
        coursesSection.getChildren().addAll(coursesLabel, studyButton, assignmentsButton);

//προσθετουμε ολα τα στοιχεια στο αριστερο μερος και το επιστρεφουμε
        leftPanel.getChildren().addAll(userNameLabel, dashboardButton, calendarButton, coursesSection);
        return leftPanel;
    }



//μεθοδος για την δημιουργια του κεντρικου panel
    private VBox createCenterPanel() {
        VBox centerPanel = new VBox(10);
        centerPanel.setPadding(new Insets(20));
        centerPanel.setStyle("-fx-background-color: white;");
        
//δημιουργια της γραμμης για να αλλαζουμε τις εβδομαδες
//ΤΟ DO : οι αυξηση των εβδομαδων να ειναι δυναμικη
        HBox weekSwitcher = new HBox(10);
        weekSwitcher.setTranslateY(40);
        weekSwitcher.setAlignment(Pos.CENTER);
        
//αρχικοποιουμε την μεταβλητη weeklabel
        Label weekLabel = new Label("3 - 9 Oct 2025");
        weekLabel.setFont(Font.font("System", FontWeight.BOLD, 16));
        weekLabel.setStyle("-fx-text-fill: black;");
        

        HBox.setHgrow(weekLabel, Priority.ALWAYS);
//βαζουμε τα κουμπια τα οποια στην συνεχεια θα ειναι για να πλοηγειτε ο χρηστης στις εβδομαδες   
        Button prevButton = new Button("<");
        prevButton.setStyle("-fx-background-color: #CF308C; -fx-text-fill: white; -fx-font-size: 14px; -fx-background-radius: 30px;");
        prevButton.setPrefSize(30, 30);
        
        Button nextButton = new Button(">");
        nextButton.setStyle("-fx-background-color: #CF308C; -fx-text-fill: white; -fx-font-size: 14px; -fx-background-radius: 30px;");
        nextButton.setPrefSize(30, 30);
//ενωνουμε τα δυο κουμπια και το κειμενο
        weekSwitcher.getChildren().addAll(prevButton, weekLabel, nextButton);
        
//αρχικοποιηση του πινακα και δημιουργια του πινακα
        GridPane calendarGrid = new GridPane();
        calendarGrid.setStyle("-fx-border-color: black;");
        calendarGrid.setGridLinesVisible(true);
        createCalendarGrid(calendarGrid, besttask, schedule);
//κουμπι για την ημερα που βλεπει ο χρηστης 
//TO DO: οταν ο χρηστης επιλεγει αλλη μερα να του εμφανιζει την ημερομηνια
        Button todayButton = new Button("Today");
        todayButton.setStyle("-fx-background-color: #CF308C; -fx-background-radius: 30px; -fx-border-color: black; -fx-border-radius: 30px;");
        todayButton.setFont(Font.font("System", FontWeight.BOLD, 14));
        todayButton.setTextFill(Color.WHITE);
        
//κουμπι για να βαζει ο χρηστης την διαθεσημοτητα
        Button availabilityButton = new Button("Διαθεσιμότητα");
        availabilityButton.setStyle("-fx-background-color: #CF308C; -fx-background-radius: 30px; -fx-border-color: black; -fx-border-radius: 30px;");
        availabilityButton.setFont(Font.font("System", FontWeight.BOLD, 14));
        availabilityButton.setTextFill(Color.WHITE);
        availabilityButton.setPrefWidth(160);
//οριζουμε οταν ο ζρηστης παταει πανω στο κουμπι να ανοιγει την σελιδα popupdia
        availabilityButton.setOnAction(event ->  {
            Popupdia popup1 = new Popupdia();
            Stage popup1Stage = new Stage();
            popup1.start(popup1Stage);

        
        });

//οριζουμε την θεση του κουμπιου availiability
        StackPane availabilityPane = new StackPane(availabilityButton);
        availabilityPane.setPrefSize(150, 30);
        availabilityPane.setLayoutX(centerPanel.getWidth() - 300);
        availabilityPane.setLayoutY(200);

 //κουμπι για Refresh του προογραμματος
        Button refreshButton = new Button();
        refreshButton.setStyle("-fx-background-color: #CF308C; -fx-text-fill: white; -fx-font-size: 14px; -fx-background-radius: 30px;");
        refreshButton.setPrefSize(30, 30);

//προσθηκη εικονιδιου στο κουμπι για κυκλικα βελη
        SVGPath refreshIcon = new SVGPath();
        refreshIcon.setContent("M12 2V5C7.58 5 4 8.58 4 13C4 15.27 5.05 17.36 6.77 18.63L8.22 17.18C7.04 16.17 6.27 14.67 6.27 13C6.27 9.8 8.8 7.27 12 7.27V10L16 6L12 2ZM18.23 4.37L16.78 5.82C17.96 6.83 18.73 8.33 18.73 10C18.73 13.2 16.2 15.73 13 15.73V12L9 16L13 20V17C17.42 17 21 13.42 21 9C21 6.73 19.95 4.64 18.23 4.37Z");
        refreshIcon.setFill(Color.WHITE);
        refreshButton.setGraphic(refreshIcon);

        refreshButton.setOnAction(event -> {
    
        });
        
//βαζουμε ολα τα στοιχεια του κεντρου μαζι και τα επιστρεφουμε
        centerPanel.getChildren().addAll(weekSwitcher, todayButton, calendarGrid, availabilityPane, refreshButton);
        
        return centerPanel;
    }
    


//μεθοδος για την δημιουργια του δεξιου panel
    private VBox createRightPanel() {
        VBox rightPanel = new VBox(10);
        rightPanel.setPadding(new Insets(10));
        rightPanel.setAlignment(Pos.TOP_CENTER);
    

        rightPanel.setPrefHeight(Double.MAX_VALUE);
    
//βαζουμε τα δυο task 
        VBox upcomingTasksBox = createTaskBoxWithChecklist("Upcoming Tasks", "#96E2D6");
        VBox completedTasksBox = createTaskBoxWithChecklist("Completed Tasks", "#15B569");
    
//χωριζουμε δυναμικα τα task το μεγεθος να μοιραζονται στην μεση
        VBox.setVgrow(upcomingTasksBox, Priority.ALWAYS);
        VBox.setVgrow(completedTasksBox, Priority.ALWAYS);
    
//προσθετουμε και επιστρεφουμε το δεξι panel
        rightPanel.getChildren().addAll(upcomingTasksBox, completedTasksBox);
    
        return rightPanel;
    }
//δημιουργουμε τα checkbox που στην συνεχεια πρεπει να κατανημουμε αναλογα τα task
    private VBox createTaskBoxWithChecklist(String title, String color) {
        VBox box = new VBox(5);
        box.setStyle("-fx-border-color: black; -fx-border-radius: 5; -fx-background-radius: 5;");
        box.setPrefWidth(250);
        box.setPrefHeight(250);
    
        Label titleLabel = new Label(title);
        titleLabel.setStyle("-fx-background-color: " + color + "; -fx-padding: 10; -fx-background-radius: 5;");
        titleLabel.setTextFill(Color.web("#1e1d1d"));
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setMaxWidth(Double.MAX_VALUE);
    

        VBox tasksList = new VBox(5);
        tasksList.setStyle("-fx-padding: 10;");
        

        tasksList.getChildren().add(createCheckBox("Task 1"));
        tasksList.getChildren().add(createCheckBox("Task 2"));
        tasksList.getChildren().add(createCheckBox("Task 3"));
        
        box.getChildren().addAll(titleLabel, tasksList);
        
        return box;
    }

//μεθοδος χειρισμου των κουμπιων που βρισκονται στο αριστερο panel
    private Button createSideButton1(String text) {
        Button button = new Button(text);
        button.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 18px;");
        return button;
    }




//δημιουργουμε τα checkbox 
    private HBox createCheckBox(String taskName) {
        HBox checkBoxBox = new HBox(10);
        checkBoxBox.setAlignment(Pos.CENTER_LEFT);
        

        javafx.scene.control.CheckBox taskCheckBox = new javafx.scene.control.CheckBox(taskName);
        taskCheckBox.setStyle("-fx-font-size: 16px; -fx-text-fill: black;");
        
        checkBoxBox.getChildren().add(taskCheckBox);
        
        return checkBoxBox;
    }

//δημιουργουμε το ημερολογιο
    private void createCalendarGrid(GridPane grid, List<Task> besttask, int[][] schedule) {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};


//ρυθμιζουμε το πλατος για τις 7 στηλες
        for (int i = 0; i < days.length; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100.0 / 7);
            grid.getColumnConstraints().add(column);
        }

//βαζουμε τους τιτλους για την καθε μερα 
        for (int i = 0; i < days.length; i++) {
            Label dayLabel = new Label(days[i]);
            dayLabel.setStyle("-fx-font-weight: bold; -fx-border-color: gray; -fx-border-width: 0; -fx-alignment: center;");
            dayLabel.setFont(Font.font("System", FontWeight.BOLD, 18));
            dayLabel.setPrefHeight(60);
            dayLabel.setPrefWidth(140);
            GridPane.setConstraints(dayLabel, i, 0);
            grid.getChildren().add(dayLabel);
        }

//να εχουν ολες γραμμες το ιδιο υψος 
        for (int i = 0; i < 11; i++) {  // 11 γραμμες για τον πινακα
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100.0 / 11);
            grid.getRowConstraints().add(row);
        }


        for (int row = 1; row < 11; row++) {
            for (int col = 0; col <= days.length - 1; col++) {
                Label cell = new Label();
                cell.setStyle("-fx-border-color: gray; -fx-border-width: 0; -fx-alignment: center;");
                cell.setFont(Font.font("System", FontWeight.NORMAL, 14));
                cell.setPrefSize(140, 60);
                //cell.setText(SimulateAnnealing.printSchedule(row, col));
                //MainTestAlgorithm algorithm = new MainTestAlgorithm();
                //cell.setText(algorithm.run(row, col));
                //cell.setText(besttask.get(row).toString());
                if (schedule != null && besttask != null &&
                    row < schedule.length && col < schedule[row].length &&
                    schedule[row][col] > 0 && schedule[row][col] <= besttask.size()) {

                    int taskIndex = schedule[row][col] - 1;
                    if (taskIndex >= 0 && taskIndex < besttask.size()) {
                        //cell.setText(besttask.get(taskIndex).toString());
                        String taskText = besttask.get(taskIndex).toString();
                        //cell.setText(taskText);
                        String firstWord = taskText.split(" ")[0];
                        for (Subject subject : subjects) {
                            if (subject.getCourseName().equalsIgnoreCase(firstWord)) {
                                cell.setStyle("-fx-background-color: " + subject.getColor() + "; " +
                                    "-fx-border-color: gray; -fx-border-width: 0; -fx-alignment: center;");
                                break;
                            }
                        }
                    }else {
                        cell.setText(""); 
                    }
                } else {
                    cell.setText("");
                }



//οταν ο χρηστης παταει πανω σε οποιδηποτε κελη τοτε του εμφανιζεται η σελιδα popupdiathesimotita
                cell.setOnMouseClicked(event -> {

                    Popupdiathesimotita popup = new Popupdiathesimotita();
                    Stage popupStage = new Stage();
                    popup.start(popupStage);
                });
            
                GridPane.setConstraints(cell, col, row );
                grid.getChildren().add(cell);
            }
        }
    }





    public static void main(String[] args) {
        launch(args);
    }
}
