package ru.valkonsky.taskmanager.controller.impl;


import ru.valkonsky.taskmanager.controller.AuthController;
import ru.valkonsky.taskmanager.entity.User;
import ru.valkonsky.taskmanager.repository.AuthModelLayer;
import ru.valkonsky.taskmanager.repository.impl.SQLAuthModelLayerImpl;

public class AuthControllerImpl implements AuthController {
    AuthModelLayer authModelLayer;

    public AuthControllerImpl(){
        authModelLayer  = new SQLAuthModelLayerImpl();
    }

    @Override
    public User getUserById(int id) {
        return authModelLayer.getUserById(id);
    }

    @Override
    public User getUserByLoginAndPass(String name, String pass) {
        return authModelLayer.getUserByLoginAndPass(name,pass);
    }

    @Override
    public void addUser(String name, String pass) {
        authModelLayer.addUser(name,pass);
    }
}
