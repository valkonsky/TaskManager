package ru.valkonsky;

import ru.valkonsky.controller.AuthController;
import ru.valkonsky.controller.impl.AuthControllerImpl;
import ru.valkonsky.repository.AuthModelLayer;
import ru.valkonsky.repository.TasksModelLayer;
import ru.valkonsky.repository.impl.SQLAuthModelLayerImpl;
import ru.valkonsky.repository.impl.TasksSQLModelLayerImpl;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        AuthController authController  = new AuthControllerImpl();
        System.out.println(authController.getUserById(1).getName());
        System.out.println(authController.getUserById(2).getName());
    }
}