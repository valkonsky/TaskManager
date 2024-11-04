package ru.valkonsky;

import ru.valkonsky.entity.User;
import ru.valkonsky.repository.AuthModelLayer;
import ru.valkonsky.repository.TasksModelLayer;
import ru.valkonsky.repository.impl.AuthModelLayerImpl;
import ru.valkonsky.repository.impl.TasksSQLModelLayerImpl;

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        AuthModelLayer authModelLayer = new AuthModelLayerImpl();
        TasksModelLayer tasksModelLayer = new TasksSQLModelLayerImpl();

        tasksModelLayer.addTask(3,"testJavaTask","testJavaDescription", Timestamp.valueOf((java.time.LocalDate.of(2024,11,4).atStartOfDay())),1);

    }
}