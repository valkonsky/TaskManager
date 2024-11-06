package ru.valkonsky.controller;

import ru.valkonsky.entity.User;

public interface AuthController {

    User getUserById(int id);

    User getUserByLoginAndPass(String name, String pass);
}
