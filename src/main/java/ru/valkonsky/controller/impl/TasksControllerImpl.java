package ru.valkonsky.controller.impl;

import ru.valkonsky.controller.TasksController;
import ru.valkonsky.entity.Task;
import ru.valkonsky.repository.TasksModelLayer;
import ru.valkonsky.repository.impl.TasksSQLModelLayerImpl;

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
    public void removeTask(int id) {

    }

    @Override
    public void addTask(Task task) {
        tasksModelLayer.addTask(task.getName(),task.getDescription(),task.getTimestamp(), task.getUserId());
    }
}
