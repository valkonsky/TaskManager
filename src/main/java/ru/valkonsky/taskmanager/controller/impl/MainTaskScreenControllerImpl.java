package ru.valkonsky.taskmanager.controller.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import ru.valkonsky.taskmanager.repository.AuthModelLayer;
import ru.valkonsky.taskmanager.repository.TasksModelLayer;
import ru.valkonsky.taskmanager.repository.impl.SQLAuthModelLayerImpl;
import ru.valkonsky.taskmanager.repository.impl.TasksSQLModelLayerImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class MainTaskScreenControllerImpl {

    public static int userId = 0;
    AuthModelLayer authModelLayer;
    TasksModelLayer tasksModelLayer;

    public MainTaskScreenControllerImpl(){
        authModelLayer = new SQLAuthModelLayerImpl();
        tasksModelLayer = new TasksSQLModelLayerImpl();
    }
    @FXML
    Label user;

    @FXML
    ListView<String> tasks;

    @FXML
    public void initialize() {
        user.setText(authModelLayer.getUserById(userId).getName());
        ObservableList<String> tasks1 = FXCollections.observableArrayList(tasksModelLayer.getAllTasksByUserId(userId).toString());
        tasks.setItems(tasks1);

    }
}
