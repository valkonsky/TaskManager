package ru.valkonsky.taskmanager.controller.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.valkonsky.taskmanager.entity.Task;
import ru.valkonsky.taskmanager.repository.AuthModelLayer;
import ru.valkonsky.taskmanager.repository.TasksModelLayer;
import ru.valkonsky.taskmanager.repository.impl.SQLAuthModelLayerImpl;
import ru.valkonsky.taskmanager.repository.impl.TasksSQLModelLayerImpl;

public class MainTaskScreenControllerImpl {

    public static int userId = 0;


    AuthModelLayer authModelLayer;
    TasksModelLayer tasksModelLayer;
    TasksControllerImpl tasksController;

    public MainTaskScreenControllerImpl(){
        authModelLayer = new SQLAuthModelLayerImpl();
        tasksModelLayer = new TasksSQLModelLayerImpl();
        tasksController = new TasksControllerImpl();
    }
    @FXML
    Label user;

    @FXML
    public TextField nameNewTask;
    @FXML
    public TextField descNewTask;
    @FXML
    private TableColumn<Task, String> name;
    @FXML
    private TableColumn<Task, String> description;
    @FXML
    private TableColumn<Task, String> timestamp;

    @FXML
    TableView<Task> tasks;

    @FXML
    public Button addNewTask;

    @FXML
    public void initialize() {
        user.setText(authModelLayer.getUserById(userId).getName());
        ObservableList<Task> tasks1 = FXCollections.observableArrayList();
        for (Task task:tasksModelLayer.getAllTasksByUserId(userId)){
            tasks1.add(task);
        }
        tasks.setItems(tasks1);


        tasks = new TableView<>(tasksController.getInitialList(userId));
        tasks.getColumns().addAll(TasksControllerImpl.getNameCol(),TasksControllerImpl.getDescCol(),TasksControllerImpl.geTimestampCol());
        name.setCellValueFactory(new PropertyValueFactory<Task,String>("name"));
        description.setCellValueFactory(new PropertyValueFactory<Task,String>("description"));
        timestamp.setCellValueFactory(new PropertyValueFactory<Task,String>("timestamp"));
        tasks.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tasks.setItems(tasks1);

    }

    @FXML
    public void addNewTask(ActionEvent actionEvent) {
        Task task = new Task(nameNewTask.getText(),descNewTask.getText(),userId);
        tasksController.addTask(task);
        tasks.setVisible(false);
        tasks.refresh();
        tasks.setVisible(true);
    }
}
