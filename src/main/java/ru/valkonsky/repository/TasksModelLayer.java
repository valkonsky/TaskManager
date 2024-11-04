package ru.valkonsky.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public interface TasksModelLayer {
    void addTask(int id, String name, String description, Timestamp timestamp, int userid);
    void removeTask(int id);
    void setTask(int id);
    void getTask(int id);
}
