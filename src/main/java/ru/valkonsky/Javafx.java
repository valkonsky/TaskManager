package ru.valkonsky;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.valkonsky.controller.AuthController;
import ru.valkonsky.controller.impl.AuthControllerImpl;
import ru.valkonsky.entity.User;

public class Javafx extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AuthController authController = new AuthControllerImpl();
        Label label = new Label("Task Manager");
        Label loginLabel = new Label("Login");
        Label passwordLabel = new Label("Password");
        TextField login = new TextField();
        TextField password = new TextField();
        Button submit = new Button("Auth");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                User user =authController.getUserByLoginAndPass(login.getText(),password.getText());
                if (user!=null){
                    System.out.println("id: " + user.getId());
                    System.out.println("name: " + user.getName());
                    System.out.println("password: " + user.getPassword());
                    Label label1 = new Label(user.getName());
                    VBox vBox1 = new VBox(label1);

                    Scene mainScene = new Scene(vBox1,600,600);
                    primaryStage.setScene(mainScene);
                }else{
                    System.err.println("user not found");
                }
            }
        });
        VBox vBox = new VBox();

        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(5);
        vBox.getChildren().addAll(label,loginLabel,login,passwordLabel,password,submit);
        Scene scene = new Scene(vBox,400,550);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();



    }
}