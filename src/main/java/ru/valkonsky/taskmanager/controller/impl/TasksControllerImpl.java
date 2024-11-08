package ru.valkonsky.taskmanager.controller.impl;


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
}
