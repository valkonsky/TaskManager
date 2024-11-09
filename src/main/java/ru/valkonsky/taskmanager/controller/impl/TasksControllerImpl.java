package ru.valkonsky.taskmanager.controller.impl;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.valkonsky.taskmanager.controller.TasksController;
import ru.valkonsky.taskmanager.entity.Task;
import ru.valkonsky.taskmanager.repository.TasksModelLayer;
import ru.valkonsky.taskmanager.repository.impl.TasksSQLModelLayerImpl;

import java.util.List;

public class TasksControllerImpl implements TasksController {
    TasksModelLayer tasksModelLayer;

    public TasksControllerImpl(){
        tasksModelLayer = new TasksSQLModelLayerImpl();
    }
    @Override
    public Task getTaskById(int id) {
        return null;
    }

    @Override
    public List<Task> getAllTaskByUserId(int id) {
        return tasksModelLayer.getAllTasksByUserId(id);
    }

    @Override
    public void removeTask(int id) {

    }

    @Override
    public void addTask(Task task) {
        tasksModelLayer.addTask(task.getName(),task.getDescription(),task.getTimestamp(), task.getUserId());
    }

    public ObservableList<Task> getInitialList(int id){
        ObservableList<Task> tasksForUser = FXCollections.observableArrayList();
        for (Task task :getAllTaskByUserId(id)){
            tasksForUser.add(task);
        }
        return tasksForUser;
    }

    public static TableColumn<Task, String> getNameCol(){
        TableColumn<Task, String> nameCol = new TableColumn<>("name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        return nameCol;
    }
    public static TableColumn<Task, String> getDescCol(){
        TableColumn<Task, String> descCol = new TableColumn<>("description");
        descCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        return descCol;
    }
    public static TableColumn<Task, String> geTimestampCol(){
        TableColumn<Task, String> timeStampCol = new TableColumn<>("timestamp");
        timeStampCol.setCellValueFactory(new PropertyValueFactory<>("timestamp"));
        return timeStampCol;
    }
}
