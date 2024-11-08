package ru.valkonsky;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.valkonsky.controller.AuthController;
import ru.valkonsky.controller.TasksController;
import ru.valkonsky.controller.impl.AuthControllerImpl;
import ru.valkonsky.controller.impl.TasksControllerImpl;
import ru.valkonsky.entity.Task;
import ru.valkonsky.entity.User;

import java.sql.Timestamp;

public class Javafx extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AuthController authController = new AuthControllerImpl();
        TasksController tasksController = new TasksControllerImpl();
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
                if (user!=null) {
                    System.out.println("id: " + user.getId());
                    System.out.println("name: " + user.getName());
                    System.out.println("password: " + user.getPassword());
                    Label label1 = new Label(user.getName());


                    ObservableList<Task> observableList = FXCollections.observableArrayList();
                    observableList.addAll(tasksController.getAllTaskByUserId(user.getId()));
                    ListView<Task>listView = new ListView<>(observableList);
                    BorderPane borderPane = new BorderPane(listView);

                    Scene mainScene = new Scene(borderPane, 600, 600);
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