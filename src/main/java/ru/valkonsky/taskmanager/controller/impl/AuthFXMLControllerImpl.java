package ru.valkonsky.taskmanager.controller.impl;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AuthFXMLControllerImpl {

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button login;

    @FXML
    private Button register;
}
