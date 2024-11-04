package ru.valkonsky.repository.impl;

import ru.valkonsky.DatabaseConnector;
import ru.valkonsky.entity.Task;
import ru.valkonsky.repository.TasksModelLayer;

import java.sql.*;

public class TasksSQLModelLayerImpl implements TasksModelLayer {
    Connection connection  = DatabaseConnector.getConnection();
    ResultSet resultSet;
    Task task = null;

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
        String query = "DELETE FROM tasks.tasks WHERE id =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Task getTask(int id) {

        String query = "SELECT * FROM tasks.tasks WHERE id = ?";
        try {
            PreparedStatement preparedStatement  = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                task = new Task(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("description")
                        ,resultSet.getTimestamp("timestamp"),resultSet.getInt("userid"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return task;
    }
}
