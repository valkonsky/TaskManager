package ru.valkonsky.repository;

public interface TasksModelLayer {
    void addTask();
    void removeTask(int id);
    void setTask(int id);
    void getTask(int id);
}
