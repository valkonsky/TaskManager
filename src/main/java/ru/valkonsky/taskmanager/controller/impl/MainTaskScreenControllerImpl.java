package ru.valkonsky.taskmanager.controller.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import ru.valkonsky.taskmanager.entity.Task;
import ru.valkonsky.taskmanager.repository.AuthModelLayer;
import ru.valkonsky.taskmanager.repository.TasksModelLayer;
import ru.valkonsky.taskmanager.repository.impl.SQLAuthModelLayerImpl;
import ru.valkonsky.taskmanager.repository.impl.TasksSQLModelLayerImpl;

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
    public Button addNewTask;

    @FXML
    public void initialize() {
        user.setText(authModelLayer.getUserById(userId).getName());
        ObservableList<String> tasks1 = FXCollections.observableArrayList();
        for (Task task:tasksModelLayer.getAllTasksByUserId(userId)){
            tasks1.add(task.toString());
        }
        tasks.setItems(tasks1);

    }

    @FXML
    public void addNewTask(ActionEvent actionEvent) {
        System.out.println("now not s supported");
    }
}
