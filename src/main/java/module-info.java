module org.javawavers.studybuddy {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.xerial.sqlitejdbc;

    opens org.javawavers.studybuddy to javafx.fxml;
    exports org.javawavers.studybuddy;
    exports org.javawavers.studybuddy.courses;
    opens org.javawavers.studybuddy.courses to javafx.fxml;
    exports org.javawavers.studybuddy.database;
    opens org.javawavers.studybuddy.database to javafx.fxml;
    exports org.javawavers.studybuddy.utility;
    opens org.javawavers.studybuddy.utility to javafx.fxml;
    exports org.javawavers.studybuddy.graphs;
    opens org.javawavers.studybuddy.graphs to javafx.fxml;
    exports org.javawavers.studybuddy.calculations;
    opens org.javawavers.studybuddy.calculations to javafx.fxml;
    exports org.javawavers.studybuddy.ui_ux;
    opens org.javawavers.studybuddy.ui_ux to javafx.fxml;
}