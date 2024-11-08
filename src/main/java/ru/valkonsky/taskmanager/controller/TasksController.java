package ru.valkonsky.taskmanager.controller;

import ru.valkonsky.taskmanager.entity.Task;

import java.util.List;

public interface TasksController {

    Task getTaskById(int id);
    List<Task> getAllTaskByUserId(int id);
    void removeTask(int id);
    void addTask(Task task);

}
