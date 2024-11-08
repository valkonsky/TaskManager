package ru.valkonsky.controller;

import ru.valkonsky.entity.Task;

import java.util.List;

public interface TasksController {

    Task getTaskById(int id);
    List<Task> getAllTaskByUserId(int id);
    void removeTask(int id);
    void addTask(Task task);

}
