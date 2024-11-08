package ru.valkonsky.repository;

import ru.valkonsky.entity.Task;

import java.sql.Timestamp;
import java.util.List;

public interface TasksModelLayer {
    void addTask( String name, String description, Timestamp timestamp, int userid);
    void removeTask(int id);
    Task getTask(int id);
    List<Task> getAllTasksByUserId(int userid);
}
