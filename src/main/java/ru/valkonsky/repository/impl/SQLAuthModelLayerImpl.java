package ru.valkonsky.repository.impl;

import ru.valkonsky.DatabaseConnector;
import ru.valkonsky.entity.User;
import ru.valkonsky.repository.AuthModelLayer;

import java.sql.*;

public class SQLAuthModelLayerImpl implements AuthModelLayer {
    Connection connection  = DatabaseConnector.getConnection();
    Statement statement;
    ResultSet resultSet;

    {
        try {
            statement = connection.createStatement();
            resultSet = statement.getResultSet();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getUserById(int id)// rewrite to preparedstatement
     {
        try {
            resultSet = statement.executeQuery("SELECT * FROM tasks.users WHERE id="+ id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        while(true){
            try {
                if (resultSet.next()) {
                    return new User(resultSet.getInt("id"),resultSet.getString("name"), resultSet.getString("password"));
                }
                else{
                  throw new SQLException();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
     }

    @Override
    public User getUserByLoginAndPass(String login, String password) {
        User user = null;
        String query = "SELECT * FROM tasks.users WHERE name= ? AND password = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,login);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user =  new User(resultSet.getInt("id"),resultSet.getString("name"), resultSet.getString("password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public void removeUser() {

    }

    @Override
    public void addUser() {

    }
}
