package ru.valkonsky.controller;

import ru.valkonsky.entity.Task;

public interface TasksController {

    Task getTaskById(int id);
    void removeTask(int id);
    void addTask(Task task);

}
