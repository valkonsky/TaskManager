package ru.valkonsky;

import ru.valkonsky.entity.User;
import ru.valkonsky.repository.AuthModelLayer;
import ru.valkonsky.repository.impl.AuthModelLayerImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        AuthModelLayer authModelLayer = new AuthModelLayerImpl();

        System.out.println("Authentciation");
        System.out.println("Input login");
        Scanner scanner = new Scanner(System.in);
        String login = scanner.next();
        System.out.println("Input password");
        String pass = scanner.next();
        User user = authModelLayer.getUserByLoginAndPass(login,pass);
        System.out.println(user.getName());
        System.out.println(user.getPassword());
    }
}