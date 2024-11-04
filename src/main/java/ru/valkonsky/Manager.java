package ru.valkonsky;

import ru.valkonsky.entity.Task;

public interface Manager {


    void create(Task task);
    void delete(int id);
    void get(int id);
}
