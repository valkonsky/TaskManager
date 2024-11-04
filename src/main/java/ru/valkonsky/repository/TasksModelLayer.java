package ru.valkonsky.repository;

import ru.valkonsky.entity.Task;

import java.sql.Timestamp;

public interface TasksModelLayer {
    void addTask(int id, String name, String description, Timestamp timestamp, int userid);
    void removeTask(int id);
    Task getTask(int id);
}
