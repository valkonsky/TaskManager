package ru.valkonsky.controller.impl;

import ru.valkonsky.controller.AuthController;
import ru.valkonsky.entity.User;
import ru.valkonsky.repository.AuthModelLayer;
import ru.valkonsky.repository.impl.SQLAuthModelLayerImpl;

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
