package ru.valkonsky.repository.impl;

import ru.valkonsky.DatabaseConnector;
import ru.valkonsky.entity.Task;
import ru.valkonsky.repository.TasksModelLayer;

import java.sql.*;
import java.time.LocalDateTime;

public class TasksSQLModelLayerImpl implements TasksModelLayer {
    Task task;
    Connection connection  = DatabaseConnector.getConnection();
    Statement statement;
    ResultSet resultSet;

    @Override
    public void addTask(int id, String name, String description, Timestamp timestamp, int userid) {
        String query = "INSERT INTO tasks.tasks VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,description);
            preparedStatement.setTimestamp(4,timestamp);
            preparedStatement.setInt(5,userid);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeTask(int id) {

    }

    @Override
    public void setTask(int id) {

    }

    @Override
    public void getTask(int id) {

    }
}
