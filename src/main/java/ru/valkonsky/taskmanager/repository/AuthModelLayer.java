package ru.valkonsky.taskmanager.repository;


import ru.valkonsky.taskmanager.entity.User;

public interface AuthModelLayer {
    User getUserById(int id);
    User getUserByLoginAndPass(String login, String password);
    void removeUser();
    void addUser(String login, String password);
}
