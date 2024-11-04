package ru.valkonsky.repository;

import ru.valkonsky.entity.User;

public interface AuthModelLayer {
    User getUserById(int id);
    User getUserByLoginAndPass(String login, String password);
    void removeUser();
    void addUser();
}
