package ru.valkonsky.taskmanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ru.valkonsky.taskmanager.entity.User;
import ru.valkonsky.taskmanager.repository.AuthModelLayer;
import ru.valkonsky.taskmanager.repository.impl.SQLAuthModelLayerImpl;

public class AuthController {
    private AuthModelLayer authModelLayer;

    public AuthController(){
        authModelLayer = new SQLAuthModelLayerImpl();
    }


    @FXML
    private Button login;

    @FXML
    private Button register;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    protected void authorizeUser(){
        User user = authModelLayer.getUserByLoginAndPass(loginField.getText(),passwordField.getText());
        if (user!=null){
            System.out.println("authorization corrent");
        }else{
            System.err.println("wrong data");
        }

    }

    @FXML
    public void registerUser(ActionEvent actionEvent) {
        System.err.println("register new user not supported now");
    }
}
