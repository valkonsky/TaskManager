package ru.valkonsky.taskmanager.repository.impl;



import ru.valkonsky.taskmanager.DataBaseConnector;
import ru.valkonsky.taskmanager.entity.Task;
import ru.valkonsky.taskmanager.repository.TasksModelLayer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TasksSQLModelLayerImpl implements TasksModelLayer {
    Connection connection  = DataBaseConnector.getConnection();
    ResultSet resultSet;
    Task task = null;

    @Override
    public void addTask( String name, String description, Timestamp timestamp, int userid) {
        String query = "INSERT INTO tasks.tasks (\"name\", \"description\",\"timestamp\",\"userid\") VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            //preparedStatement.setInt(1,id);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,description);
            preparedStatement.setTimestamp(3,timestamp);
            preparedStatement.setInt(4,userid);

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
                task = new Task(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description")
                        ,resultSet.getTimestamp("timestamp"),
                        resultSet.getInt("userid"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return task;
    }

    @Override
    public List<Task> getAllTasksByUserId(int userid) {
        List<Task> tasks = new ArrayList<>();
        String query = "SELECT * FROM tasks.tasks WHERE tasks.userid = ?";
        try {
            PreparedStatement preparedStatement  = connection.prepareStatement(query);
            preparedStatement.setInt(1,userid);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                task = new Task(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("description")
                        ,resultSet.getTimestamp("timestamp"),resultSet.getInt("userId"));
                tasks.add(task);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tasks;
    }
}
