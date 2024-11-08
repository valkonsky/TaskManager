module ru.valkonsky.taskmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ru.valkonsky.taskmanager to javafx.fxml;
    exports ru.valkonsky.taskmanager;
}