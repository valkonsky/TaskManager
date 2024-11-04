package ru.valkonsky;

import ru.valkonsky.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskManagerImpl implements Manager {

    private List<Task> tasks;

    public TaskManagerImpl(){
        this.tasks = new ArrayList<>();
    }
    @Override
    public void create(Task task) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void get(int id) {

    }
}
