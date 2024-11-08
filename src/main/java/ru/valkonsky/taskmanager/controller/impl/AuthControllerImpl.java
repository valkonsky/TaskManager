package ru.valkonsky.taskmanager.controller.impl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.valkonsky.taskmanager.Main;
import ru.valkonsky.taskmanager.entity.User;
import ru.valkonsky.taskmanager.repository.AuthModelLayer;
import ru.valkonsky.taskmanager.repository.impl.SQLAuthModelLayerImpl;

import java.io.IOException;

public class AuthControllerImpl {
    private AuthModelLayer authModelLayer;

    public AuthControllerImpl(){
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
    protected void authorizeUser() throws IOException {
        User user = authModelLayer.getUserByLoginAndPass(loginField.getText(),passwordField.getText());
        if (user!=null){
            Stage stage = (Stage) login.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mainTaskScreen.fxml"));
            Parent root1 =fxmlLoader.load();
            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("MainScreen");
            stage.setScene(new Scene(root1));
            stage.show();
        }else{
            System.err.println("wrong data");
        }

    }

    @FXML
    public void registerUser(ActionEvent actionEvent) {
        System.err.println("register new user not supported now");
    }
}
