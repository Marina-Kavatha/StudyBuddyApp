module org.javawavers.studybuddy {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens org.javawavers.studybuddy to javafx.fxml;
    exports org.javawavers.studybuddy;
}