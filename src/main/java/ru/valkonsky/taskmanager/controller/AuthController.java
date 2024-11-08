package ru.valkonsky.taskmanager.controller;


import ru.valkonsky.taskmanager.entity.User;

public interface AuthController {

    User getUserById(int id);

    User getUserByLoginAndPass(String name, String pass);
    void addUser(String name, String pass);
}
